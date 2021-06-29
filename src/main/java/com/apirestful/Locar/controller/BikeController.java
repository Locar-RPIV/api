package com.apirestful.Locar.controller;

import java.util.List;

import com.apirestful.Locar.Services.BikeService;
import com.apirestful.Locar.model.Bike;
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
public class BikeController {
    
    @Autowired
    BikeService bikeService;

    @GetMapping("/bikes")
    public <Any> Any listBikes() {
        Response response = new Response();
        try {
            return (Any) bikeService.findAll();
        } catch (Exception e) {
            response.setMessage("Erro interno.");
            return (Any) new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/bikes/partner/{cpfParceiro}")
    public List<Bike> cpfBikePartner(@PathVariable(value = "cpfParceiro") String cpfParceiro) {
        return bikeService.findByCpfParceiro(cpfParceiro);
    }

    @GetMapping("/bikes/{id}")
    public Bike idBike(@PathVariable(value = "id") int id) {
        return bikeService.findById(id);
    }

    @GetMapping("/bikes/filial/{id}")
    public List<Bike> bikeFilial(@PathVariable(value = "id") int id) {
        return bikeService.findByFilial(id);
    }

    @GetMapping("/bikes/modelo/{modelo}")
    public List<Bike> modeloBikes(@PathVariable(value = "modelo") String modelo) {
        return bikeService.findByModelo(modelo);
    }

    @GetMapping("/bikes/status/{status}")
    public List<Bike> statusBikes(@PathVariable(value = "status") String status) {
        return bikeService.findByStatus(status);
    }

    @PostMapping("/bike")
    public <Any> Any saveBike(@RequestBody Bike bike) {
        Response response = new Response();
        try {
            bikeService.save(bike);

        } catch (Exception e) {
            response.setMessage("Erro interno.");
            return (Any) new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return (Any) bike;
    }

    @DeleteMapping("/bike/{id}")
    public <Any> Any deleteBike(@PathVariable(value = "id") int id) {
        Response response = new Response();
        try {
            bikeService.deleteById(id);
            return (Any) new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            response.setMessage("Erro interno.");
            return (Any) new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/bike")
    public <Any> Any refreshBike(@RequestBody Bike bike) {
        Response response = new Response();
        try {
            Bike updateAuto = bikeService.findById(bike.getId());
            if (bike.getPlaca() != null) 
                updateAuto.setPlaca(bike.getPlaca());
            if (bike.getAno() != 0)
                updateAuto.setAno(bike.getAno());
            if (bike.getChassi() != null)
                updateAuto.setChassi(bike.getChassi());
            if (bike.getCor() != null)
                updateAuto.setCor(bike.getCor());
            if (bike.getFilial() != 0)
                updateAuto.setFilial(bike.getFilial());
            if (bike.getMarca() != null)
                updateAuto.setMarca(bike.getMarca());
            if (bike.getModelo() != null)
                updateAuto.setModelo(bike.getModelo());
            if (bike.getStatus() != null)
                updateAuto.setStatus(bike.getStatus());
            if (bike.getQuilometragem() > -1)
                updateAuto.setQuilometragem(bike.getQuilometragem());
            if (bike.getRenavam() != null)
                updateAuto.setRenavam(bike.getRenavam());
            if (bike.getValorLocacao() != 0)
                updateAuto.setValorLocacao(bike.getValorLocacao());
            if (bike.getNumeroAssentos() > 0)
                updateAuto.setNumeroAssentos(bike.getNumeroAssentos());
            if (bike.getAro() != null)
                updateAuto.setAro(bike.getAro());
            if (bike.getMarcha() != null)
                updateAuto.setMarcha(bike.getMarcha());
            if (bike.getAmortecedor() != null)
                updateAuto.setAmortecedor(bike.getAmortecedor());
            if (bike.getCarroParceiro() && bike.getCpfParceiro() != null) {
                updateAuto.setCarroParceiro(bike.getCarroParceiro());
                updateAuto.setCpfParceiro(bike.getCpfParceiro());
            } else {
                updateAuto.setCarroParceiro(false);
                updateAuto.setCpfParceiro("");
            }

            bikeService.save(updateAuto);
            return (Any) new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            response.setMessage("Erro interno.");
            return (Any) new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
