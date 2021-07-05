package com.apirestful.Locar.controller;

import java.util.List;

import com.apirestful.Locar.Services.BusService;
import com.apirestful.Locar.model.Bus;
import com.apirestful.Locar.model.Response;

import org.springframework.beans.factory.annotation.Autowired;
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
public class BusController {
    @Autowired
    BusService busService;
    Response responseErro = new Response("Erro interno.");

    @GetMapping("/bus")
    public <Any> Any listBus() {
        try {
            return (Any) busService.findAll();
        } catch (Exception e) {
            return (Any) responseErro;
        }
    }

    @GetMapping("/bus/partner/{cpfParceiro}")
    public List<Bus> cpfBusPartner(@PathVariable(value = "cpfParceiro") String cpfParceiro) {
        return busService.findByCpfParceiro(cpfParceiro);
    }

    @GetMapping("/bus/{id}")
    public Bus idBus(@PathVariable(value = "id") int id) {
        return busService.findById(id);
    }

    @GetMapping("/bus/filial/{id}")
    public List<Bus> busFilial(@PathVariable(value = "id") int id) {
        return busService.findByFilial(id);
    }

    @GetMapping("/bus/modelo/{modelo}")
    public List<Bus> modeloBus(@PathVariable(value = "modelo") String modelo) {
        return busService.findByModelo(modelo);
    }

    @GetMapping("/bus/status/{status}")
    public List<Bus> statusBus(@PathVariable(value = "status") String status) {
        return busService.findByStatus(status);
    }

    @PostMapping("/bus")
    public <Any> Any saveBus(@RequestBody Bus bus) {
        try {
            busService.save(bus);
        } catch (Exception e) {
            return (Any) responseErro;
        }
        return (Any) bus;
    }

    @DeleteMapping("/bus/{id}")
    public <Any> Any deleteBus(@PathVariable(value = "id") int id) {
        try {
            busService.deleteById(id);
            return (Any) new Response("Veiculo apagado.");
        } catch (Exception e) {
            return (Any) responseErro;
        }
    }

    @PutMapping("/bus")
    public <Any> Any editBus(@RequestBody Bus bus) {
        try {
            Bus updateAuto = busService.findById(bus.getId());
            if (bus.getPlaca() != null) 
                updateAuto.setPlaca(bus.getPlaca());
            if (bus.getAno() != 0)
                updateAuto.setAno(bus.getAno());
            if (bus.getChassi() != null)
                updateAuto.setChassi(bus.getChassi());
            if (bus.getCor() != null)
                updateAuto.setCor(bus.getCor());
            if (bus.getFilial() != 0)
                updateAuto.setFilial(bus.getFilial());
            if (bus.getMarca() != null)
                updateAuto.setMarca(bus.getMarca());
            if (bus.getModelo() != null)
                updateAuto.setModelo(bus.getModelo());
            if (bus.getStatus() != null)
                updateAuto.setStatus(bus.getStatus());
            if (bus.getQuilometragem() > -1)
                updateAuto.setQuilometragem(bus.getQuilometragem());
            if (bus.getRenavam() != null)
                updateAuto.setRenavam(bus.getRenavam());
            if (bus.getValorLocacao() != 0)
                updateAuto.setValorLocacao(bus.getValorLocacao());
            if (bus.getNumeroAssentos() > 0)
                updateAuto.setNumeroAssentos(bus.getNumeroAssentos());
            if (bus.getAro() != null)
                updateAuto.setAro(bus.getAro());
            if (bus.getMarcha() != null)
                updateAuto.setMarcha(bus.getMarcha());
            if (bus.getAmortecedor() != null)
                updateAuto.setAmortecedor(bus.getAmortecedor());
            if (bus.getPotencia() != null) 
                updateAuto.setPotencia(bus.getPotencia());
            if (bus.getTipoCombustivel() > 0)
                updateAuto.setTipoCombustivel(bus.getTipoCombustivel());
            if (bus.getNumeroPortas() > 0) 
                updateAuto.setNumeroPortas(bus.getNumeroPortas());
            if (bus.getCapacidadePortaMalas() != null) 
                updateAuto.setCapacidadePortaMalas(bus.getCapacidadePortaMalas());
            if (bus.getCarroParceiro() && bus.getCpfParceiro() != null) {
                updateAuto.setCarroParceiro(bus.getCarroParceiro());
                updateAuto.setCpfParceiro(bus.getCpfParceiro());
            } else {
                updateAuto.setCarroParceiro(false);
                updateAuto.setCpfParceiro("");
            }

            return (Any) busService.save(updateAuto);
        } catch (Exception e) {
            return (Any) responseErro;
        }
    }
}
