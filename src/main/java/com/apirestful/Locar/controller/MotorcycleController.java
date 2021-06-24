package com.apirestful.Locar.controller;

import java.util.List;

import com.apirestful.Locar.Services.MotorcycleService;
import com.apirestful.Locar.model.Automovel;
import com.apirestful.Locar.model.Motorcycle;
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
public class MotorcycleController {
    @Autowired
    MotorcycleService motoService;

    @GetMapping("/automobile")
    public <Any> Any listAutomoveis() {
        Response response = new Response();
        try {
            return (Any) motoService.findAll();
        } catch (Exception e) {
            response.setMessage("Erro interno.");
            return (Any) new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/automobile/partner/{cpfParceiro}")
    public List<Motorcycle> idAutomovel(@PathVariable(value = "cpfParceiro") String cpfParceiro) {
        return motoService.findByCpfParceiro(cpfParceiro);
    }

    @GetMapping("/automobile/{id}")
    public Motorcycle idAutomovel(@PathVariable(value = "id") int id) {
        return motoService.findById(id);
    }

    @GetMapping("/automobile/filial/{id}")
    public List<Motorcycle> AutomoveisFilial(@PathVariable(value = "id") int id) {
        return motoService.findByFilial(id);
    }

    @GetMapping("/automobile/modelo/{modelo}")
    public List<Motorcycle> modeloFilial(@PathVariable(value = "modelo") String modelo) {
        return motoService.findByModelo(modelo);
    }

    @GetMapping("/automobile/status/{status}")
    public List<Motorcycle> statusAutomovel(@PathVariable(value = "status") String status) {
        return motoService.findByStatus(status);
    }

    @PostMapping("/automobile")
    public <Any> Any saveAutomovel(@RequestBody Motorcycle moto) {
        Response response = new Response();
        try {
            motoService.save(moto);

        } catch (Exception e) {
            response.setMessage("Erro interno.");
            return (Any) new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return (Any) moto;
    }

    @DeleteMapping("/automobile/{id}")
    public <Any> Any deleteAutomovel(@PathVariable(value = "id") int id) {
        Response response = new Response();
        try {
            motoService.deleteById(id);
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
            Motorcycle updateAuto = motoService.findById(automovel.getId());
            if (automovel.getAno() != 0)
                updateAuto.setAno(automovel.getAno());
            if (automovel.getChassi() != null)
                updateAuto.setChassi(automovel.getChassi());
            if (automovel.getCor() != null)
                updateAuto.setCor(automovel.getCor());
            if (automovel.getFilial() != 0)
                updateAuto.setFilial(automovel.getFilial());
            if (automovel.getMarca() != null)
                updateAuto.setMarca(automovel.getMarca());
            if (automovel.getModelo() != null)
                updateAuto.setModelo(automovel.getModelo());
            if (automovel.getStatus() != null)
                updateAuto.setStatus(automovel.getStatus());
            if (automovel.getQuilometragem() > -1)
                updateAuto.setQuilometragem(automovel.getQuilometragem());
            if (automovel.getRenavam() != null)
                updateAuto.setRenavam(automovel.getRenavam());
            if (automovel.getValorLocacao() != 0)
                updateAuto.setValorLocacao(automovel.getValorLocacao());
            if (automovel.getNumeroAssentos() > 0)
                updateAuto.setNumeroAssentos(automovel.getNumeroAssentos());
            if (automovel.getCarroParceiro() && automovel.getCpfParceiro() != null) {
                updateAuto.setCarroParceiro(automovel.getCarroParceiro());
                updateAuto.setCpfParceiro(automovel.getCpfParceiro());
            } else {
                updateAuto.setCarroParceiro(false);
                updateAuto.setCpfParceiro("");
            }

            motoService.save(updateAuto);
            return (Any) new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            response.setMessage("Erro interno.");
            return (Any) new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
