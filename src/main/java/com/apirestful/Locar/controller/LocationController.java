package com.apirestful.Locar.controller;

import java.util.List;

import com.apirestful.Locar.Services.LocationService;
import com.apirestful.Locar.model.Location;
import com.apirestful.Locar.model.Reservation;
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

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")
public class LocationController {

    @Autowired
    LocationService locacaoService;

    Response responseErro = new Response("Erro interno.");

    @GetMapping(value = "/location")
    public List<Location> listLocacoes() {
        return locacaoService.findAll();
    }

    @GetMapping(value = "/location/{id}")
    public Location idLocacao(@PathVariable(value = "id") int id) {
        return locacaoService.findById(id);
    }

    @PostMapping(value = "/location")
    public Location saveLocacao(@RequestBody Location locacao) {

        int reservaId = locacao.getReserva().getId();
        Reservation reserva = locacaoService.findByIdReservation(reservaId);
        locacao.setReserva(reserva);
        
        return locacaoService.save(locacao);
    }

    @PutMapping(value="/location")
    public <Any> Any editLocacao(@RequestBody Location locacao) {
        try {
            Location updateLocation = locacaoService.findById(locacao.getId());
            if (locacao.getReserva() != null) {
                int reservaId = locacao.getReserva().getId();
                Reservation reserva = locacaoService.findByIdReservation(reservaId);
                updateLocation.setReserva(reserva);
            }
            if (locacao.getDataLocacao() != null)
                updateLocation.setDataLocacao(locacao.getDataLocacao());
            if (locacao.getDataDevolucao() != null)
                updateLocation.setDataDevolucao(locacao.getDataDevolucao());
            if (locacao.getValorLocacao() > 0)
                updateLocation.setValorLocacao(locacao.getValorLocacao());
            if (locacao.getValorCaucao() > 0)
                updateLocation.setValorCaucao(locacao.getValorCaucao());
            if (locacao.getValorTotal() > 0)
                updateLocation.setValorTotal(locacao.getValorTotal());
            if (locacao.getQuilometragemLocacao() >= 0)
                updateLocation.setQuilometragemLocacao(locacao.getQuilometragemLocacao());
            if (locacao.getQuilometragemDevolucao() >= 0)
                updateLocation.setQuilometragemDevolucao(locacao.getQuilometragemDevolucao());
            if (locacao.getDuracao() >= 0.0)
                updateLocation.setDuracao(locacao.getDuracao());    
        
            return (Any) locacaoService.save(updateLocation);
        } catch (Exception e) {
            return (Any) responseErro;
        }
    }

    @DeleteMapping(value = "/location/{id}")
    public <Any> Any deleteLocacao(@PathVariable(value = "id") int id) {
        try {
            locacaoService.deleteById(id);
            return (Any) new Response("Locação apagada.");
        } catch (Exception e) {
            return (Any) responseErro;
        }
    }

}
