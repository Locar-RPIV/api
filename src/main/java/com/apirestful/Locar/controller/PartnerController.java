package com.apirestful.Locar.controller;

import java.util.Date;
import java.util.List;

import com.apirestful.Locar.Services.PartnerService;
import com.apirestful.Locar.model.Client;
import com.apirestful.Locar.model.Partner;
import com.apirestful.Locar.model.PayPartner;
import com.apirestful.Locar.model.Payment;
import com.apirestful.Locar.model.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")
public class PartnerController {

    @Autowired
    PartnerService partnerService;

    @GetMapping("/partner")
    public List<Partner> listPartners() {
        return partnerService.findAll();
    }

    @GetMapping("/partner/{rg}")
    public Client cpfPartner(@PathVariable(value = "rg") String rg) {
        return partnerService.findByRg(rg);
    }

    @PostMapping("/partner")
    public Partner savePartner(@RequestBody Partner partner) {
        String passwordCrypt = BCrypt.hashpw(partner.getPassword(), BCrypt.gensalt());
        partner.setPassword(passwordCrypt);
        partner.setAdmin(false);
        partner.setPartner(true);
        return partnerService.save(partner);
    }

    @DeleteMapping("/partner/{rg}")
    public <Any> Any deletePartner(@PathVariable(value = "rg") String rg) {
        Response response = new Response();
        try {
            partnerService.deleteByRg(rg);
            return (Any) new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            response.setMessage("Erro interno");
            return (Any) new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/partner")
    public <Any> Any refreshPartner(@RequestBody Partner partner) {
        Response response = new Response();
        try {
            Partner updatePartner = partnerService.findById(partner.getId());
            if (partner.getCpf() != null) 
                updatePartner.setCpf(partner.getCpf());
            if (partner.getNome() != null)
                updatePartner.setNome(partner.getNome());
            if (partner.getTelefone() != null)
                updatePartner.setTelefone(partner.getTelefone());
            if (partner.getDataNascimento() != null)
                updatePartner.setDataNascimento(partner.getDataNascimento());
            if (partner.getEmail() != null)
                updatePartner.setEmail(partner.getEmail());
            if  (partner.getPassword() != null) {
                String passwordCrypt = BCrypt.hashpw(partner.getPassword(), BCrypt.gensalt());
                partner.setPassword(passwordCrypt);
                updatePartner.setPassword(partner.getPassword());
            }
            if (partner.getCnh() != null)
                updatePartner.setCnh(partner.getCnh());
            if (partner.getRg() != null)
                updatePartner.setRg(partner.getRg());
            if (partner.getIsPartner()) {
                updatePartner.setPartner(partner.getIsPartner());
            } else {
                updatePartner.setPartner(false);
            }
        
            partnerService.save(updatePartner);
            return (Any) new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            response.setMessage("Erro interno.");
            return (Any) new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @SuppressWarnings("rawtypes")
    @PostMapping("/partner/pay")
    public ResponseEntity payPartner(@RequestBody PayPartner payPartner) {
        Client partner = partnerService.findByRg(payPartner.getRg());
        Response response = new Response();
        try {
            if (partner == null) {
                response.setMessage("Parceiro nao econtrado!");
                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            }
            if (payPartner.getValue() < 0) {
                response.setMessage("Valor incorreto!");
                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            }
            Date date = new Date();
            partnerService.save(
                new Payment(
                    payPartner.getRg(), 
                    payPartner.getValue(), 
                    date));
            response.setMessage("Pagamento realizado com sucesso!");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.setMessage("Erro interno.");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
