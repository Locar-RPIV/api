package com.apirestful.Locar.controller;

import java.util.List;

import com.apirestful.Locar.Services.MotorcycleService;
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

    @GetMapping("/motorcycle")
    public <Any> Any listMotorcycle() {
        Response response = new Response();
        try {
            return (Any) motoService.findAll();
        } catch (Exception e) {
            response.setMessage("Erro interno.");
            return (Any) new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/motorcycle/partner/{cpfParceiro}")
    public List<Motorcycle> idMotorcyclePartner(@PathVariable(value = "cpfParceiro") String cpfParceiro) {
        return motoService.findByCpfParceiro(cpfParceiro);
    }

    @GetMapping("/motorcycle/{id}")
    public Motorcycle idMotorcycle(@PathVariable(value = "id") int id) {
        return motoService.findById(id);
    }

    @GetMapping("/motorcycle/filial/{id}")
    public List<Motorcycle> motorcycleFilial(@PathVariable(value = "id") int id) {
        return motoService.findByFilial(id);
    }

    @GetMapping("/motorcycle/modelo/{modelo}")
    public List<Motorcycle> modeloMotorcycle(@PathVariable(value = "modelo") String modelo) {
        return motoService.findByModelo(modelo);
    }

    @GetMapping("/motorcycle/status/{status}")
    public List<Motorcycle> statusMotorcycle(@PathVariable(value = "status") String status) {
        return motoService.findByStatus(status);
    }

    @PostMapping("/motorcycle")
    public <Any> Any saveMotorcycle(@RequestBody Motorcycle moto) {
        Response response = new Response();
        try {
            motoService.save(moto);

        } catch (Exception e) {
            response.setMessage("Erro interno.");
            return (Any) new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return (Any) moto;
    }

    @DeleteMapping("/motorcycle/{id}")
    public <Any> Any deleteMotorcycle(@PathVariable(value = "id") int id) {
        Response response = new Response();
        try {
            motoService.deleteById(id);
            return (Any) new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            response.setMessage("Erro interno.");
            return (Any) new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/motorcycle")
    public <Any> Any refreshMotocycle(@RequestBody Motorcycle motorcycle) {
        Response response = new Response();
        try {
            Motorcycle updateAuto = motoService.findById(motorcycle.getId());
            if (motorcycle.getPlaca() != null) 
                updateAuto.setPlaca(motorcycle.getPlaca());
            if (motorcycle.getAno() != 0)
                updateAuto.setAno(motorcycle.getAno());
            if (motorcycle.getChassi() != null)
                updateAuto.setChassi(motorcycle.getChassi());
            if (motorcycle.getCor() != null)
                updateAuto.setCor(motorcycle.getCor());
            if (motorcycle.getFilial() != 0)
                updateAuto.setFilial(motorcycle.getFilial());
            if (motorcycle.getMarca() != null)
                updateAuto.setMarca(motorcycle.getMarca());
            if (motorcycle.getModelo() != null)
                updateAuto.setModelo(motorcycle.getModelo());
            if (motorcycle.getStatus() != null)
                updateAuto.setStatus(motorcycle.getStatus());
            if (motorcycle.getQuilometragem() > -1)
                updateAuto.setQuilometragem(motorcycle.getQuilometragem());
            if (motorcycle.getRenavam() != null)
                updateAuto.setRenavam(motorcycle.getRenavam());
            if (motorcycle.getValorLocacao() != 0)
                updateAuto.setValorLocacao(motorcycle.getValorLocacao());
            if (motorcycle.getNumeroAssentos() > 0)
                updateAuto.setNumeroAssentos(motorcycle.getNumeroAssentos());
            if (motorcycle.getAro() != null)
                updateAuto.setAro(motorcycle.getAro());
            if (motorcycle.getMarcha() != null)
                updateAuto.setMarcha(motorcycle.getMarcha());
            if (motorcycle.getAmortecedor() != null)
                updateAuto.setAmortecedor(motorcycle.getAmortecedor());
            if (motorcycle.getPotencia() != null) 
                updateAuto.setPotencia(motorcycle.getPotencia());
            if (motorcycle.getTipoCombustivel() > 0)
                updateAuto.setTipoCombustivel(motorcycle.getTipoCombustivel());
            if (motorcycle.getCapacidadePortaMalas() != null) 
                updateAuto.setCapacidadePortaMalas(motorcycle.getCapacidadePortaMalas());
            if (motorcycle.getCarroParceiro() && motorcycle.getCpfParceiro() != null) {
                updateAuto.setCarroParceiro(motorcycle.getCarroParceiro());
                updateAuto.setCpfParceiro(motorcycle.getCpfParceiro());
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
