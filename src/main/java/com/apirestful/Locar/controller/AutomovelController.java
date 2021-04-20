package com.apirestful.Locar.controller;

import java.util.List;

import com.apirestful.Locar.Services.AutomovelService;
import com.apirestful.Locar.model.Automovel;
import com.apirestful.Locar.model.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SuppressWarnings("unchecked")
@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")
public class AutomovelController {

    @Autowired
    AutomovelService automovelService;

    @GetMapping("/automobile")
    public <Any> Any listAutomoveis() {
        Response response = new Response();
        try {
            return (Any) automovelService.findAll();
        } catch (Exception e) {
            response.setMessage("Erro interno.");
            return (Any) new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/automobile/partner/{cpfParceiro}")
    public List<Automovel> idAutomovel(@PathVariable(value = "cpfParceiro") long cpfParceiro) {
        return automovelService.findByCpfParceiro(cpfParceiro);
    }

    @GetMapping("/automobile/{id}")
    public Automovel idAutomovel(@PathVariable(value = "id") int id) {
        return automovelService.findById(id);
    }

    @GetMapping("/automobile/filial/{id}")
    public List<Automovel> AutomoveisFilial(@PathVariable(value = "id") int id) {
        return automovelService.findByFilial(id);
    }

    @GetMapping("/automobile/modelo/{modelo}")
    public List<Automovel> modeloFilial(@PathVariable(value = "modelo") String modelo) {
        return automovelService.findByModelo(modelo);
    }

    @GetMapping("/automobile/status/{status}")
    public List<Automovel> statusAutomovel(@PathVariable(value = "status") String status) {
        return automovelService.findByStatus(status);
    }

    @PostMapping("/automobile")
    public <Any> Any saveAutomovel(@RequestBody Automovel automovel) {
        Response response = new Response();
        try {
            automovelService.save(automovel);

        } catch (Exception e) {
            response.setMessage("Erro interno.");
            return (Any) new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return (Any) automovel;
    }

    @DeleteMapping("/automobile/{id}")
    public <Any> Any deleteAutomovel(@PathVariable(value = "id") int id) {
        Response response = new Response();
        try {
            automovelService.deleteById(id);
            return (Any) new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            response.setMessage("Erro interno.");
            return (Any) new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/automobile")
    public <Any> Any refreshAutomovel(@RequestBody Automovel automovel) {
        Response response = new Response();
        try {
            Automovel updateAuto = automovelService.findById(automovel.getId());
            if (automovel.getAno() != 0)
                updateAuto.setAno(automovel.getAno());
            if (automovel.getChassi() != null)
                updateAuto.setChassi(automovel.getChassi());
            if (automovel.getCor() != null)
                updateAuto.setCor(automovel.getCor());
            if (automovel.getFilial() != 0)
                updateAuto.setFilial(automovel.getFilial());
            if (automovel.getImageUrl() != null)
                updateAuto.setImageUrl(automovel.getImageUrl());
            if (automovel.getMarca() != null)
                updateAuto.setMarca(automovel.getMarca());
            if (automovel.getModelo() != null)
                updateAuto.setModelo(automovel.getModelo());
            if (automovel.getNumeroPortas() != 0)
                updateAuto.setNumeroPortas(automovel.getNumeroPortas());
            if (automovel.getPlaca() != null)
                updateAuto.setPlaca(automovel.getPlaca());
            if (automovel.getPotencia() != 0)
                updateAuto.setPotencia(automovel.getPotencia());
            if (automovel.getQuilometragem() > -1)
                updateAuto.setQuilometragem(automovel.getQuilometragem());
            if (automovel.getRenavan() != 0)
                updateAuto.setRenavan(automovel.getRenavan());
            if (automovel.getTipoCombustivel() != 0)
                updateAuto.setTipoCombustivel(automovel.getTipoCombustivel());
            if (automovel.getValorLocacao() != 0)
                updateAuto.setValorLocacao(automovel.getValorLocacao());
            if (automovel.getCarroParceiro() && automovel.getCpfParceiro() != 0) {
                updateAuto.setCarroParceiro(automovel.getCarroParceiro());
                updateAuto.setCpfParceiro(automovel.getCpfParceiro());
            } else {
                updateAuto.setCarroParceiro(false);
                updateAuto.setCpfParceiro(0);
            }

            automovelService.save(updateAuto);
            return (Any) new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            response.setMessage("Erro interno.");
            return (Any) new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}