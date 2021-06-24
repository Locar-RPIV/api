package com.apirestful.Locar.controller;

import java.util.List;

import com.apirestful.Locar.Services.CarService;
import com.apirestful.Locar.model.Car;
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
public class CarController {
    @Autowired
    CarService carService;

    @GetMapping("/car")
    public <Any> Any listCar() {
        Response response = new Response();
        try {
            return (Any) carService.findAll();
        } catch (Exception e) {
            response.setMessage("Erro interno.");
            return (Any) new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/car/partner/{cpfParceiro}")
    public List<Car> idCarPartner(@PathVariable(value = "cpfParceiro") String cpfParceiro) {
        return carService.findByCpfParceiro(cpfParceiro);
    }

    @GetMapping("/car/{id}")
    public Car idCar(@PathVariable(value = "id") int id) {
        return carService.findById(id);
    }

    @GetMapping("/car/filial/{id}")
    public List<Car> carFilial(@PathVariable(value = "id") int id) {
        return carService.findByFilial(id);
    }

    @GetMapping("/car/modelo/{modelo}")
    public List<Car> modeloCar(@PathVariable(value = "modelo") String modelo) {
        return carService.findByModelo(modelo);
    }

    @GetMapping("/car/status/{status}")
    public List<Car> statusCar(@PathVariable(value = "status") String status) {
        return carService.findByStatus(status);
    }

    @PostMapping("/car")
    public <Any> Any saveCar(@RequestBody Car car) {
        Response response = new Response();
        try {
            carService.save(car);

        } catch (Exception e) {
            response.setMessage("Erro interno.");
            return (Any) new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return (Any) car;
    }

    @DeleteMapping("/car/{id}")
    public <Any> Any deleteAutomovel(@PathVariable(value = "id") int id) {
        Response response = new Response();
        try {
            carService.deleteById(id);
            return (Any) new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            response.setMessage("Erro interno.");
            return (Any) new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/car")
    public <Any> Any refreshAutomovel(@RequestBody Car car) {
        Response response = new Response();
        try {
            Car updateAuto = carService.findById(car.getId());
            if (car.getPlaca() != null) 
                updateAuto.setPlaca(car.getPlaca());
            if (car.getAno() != 0)
                updateAuto.setAno(car.getAno());
            if (car.getChassi() != null)
                updateAuto.setChassi(car.getChassi());
            if (car.getCor() != null)
                updateAuto.setCor(car.getCor());
            if (car.getFilial() != 0)
                updateAuto.setFilial(car.getFilial());
            if (car.getMarca() != null)
                updateAuto.setMarca(car.getMarca());
            if (car.getModelo() != null)
                updateAuto.setModelo(car.getModelo());
            if (car.getStatus() != null)
                updateAuto.setStatus(car.getStatus());
            if (car.getQuilometragem() > -1)
                updateAuto.setQuilometragem(car.getQuilometragem());
            if (car.getRenavam() != null)
                updateAuto.setRenavam(car.getRenavam());
            if (car.getValorLocacao() != 0)
                updateAuto.setValorLocacao(car.getValorLocacao());
            if (car.getNumeroAssentos() > 0)
                updateAuto.setNumeroAssentos(car.getNumeroAssentos());
            if (car.getAro() != null)
                updateAuto.setAro(car.getAro());
            if (car.getMarcha() != null)
                updateAuto.setMarcha(car.getMarcha());
            if (car.getAmortecedor() != null)
                updateAuto.setAmortecedor(car.getAmortecedor());
            if (car.getPotencia() != null) 
                updateAuto.setPotencia(car.getPotencia());
            if (car.getTipoCombustivel() > 0)
                updateAuto.setTipoCombustivel(car.getTipoCombustivel());
            if (car.getNumeroPortas() > 0) 
                updateAuto.setNumeroPortas(car.getNumeroPortas());
            if (car.getCapacidadePortaMalas() != null) 
                updateAuto.setCapacidadePortaMalas(car.getCapacidadePortaMalas());
            if (car.getCarroParceiro() && car.getCpfParceiro() != null) {
                updateAuto.setCarroParceiro(car.getCarroParceiro());
                updateAuto.setCpfParceiro(car.getCpfParceiro());
            } else {
                updateAuto.setCarroParceiro(false);
                updateAuto.setCpfParceiro("");
            }

            carService.save(updateAuto);
            return (Any) new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            response.setMessage("Erro interno.");
            return (Any) new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
