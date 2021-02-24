package com.apirestful.Locar.controller;

import java.util.List;

import com.apirestful.Locar.model.Reserva;
import com.apirestful.Locar.repository.ReservaRepository;

import org.springframework.beans.factory.annotation.Autowired;
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
public class ReservasController {
    
    @Autowired
    ReservaRepository reservaRepository;

    @GetMapping(value="/reservation")
    public List<Reserva> listReservas() {
        return reservaRepository.findAll();
    }
    
    @GetMapping(value="/reservation/{cpf}")
    public Reserva cpfReserva(@PathVariable(value = "cpf") long cpf) {
        return reservaRepository.findByCpf(cpf);
    }
    
    @PostMapping(value="/reservation")
    public Reserva saveReserva(@RequestBody Reserva reserva) {
        return reservaRepository.save(reserva);
    }
    
    @PutMapping(value="/reservation")
    public Reserva editReserva(@RequestBody Reserva reserva) {        
        return reservaRepository.save(reserva);
    }

    @DeleteMapping(value = "/reservation")
    public void deleteReserva(@RequestBody Reserva reserva) {
        reservaRepository.delete(reserva);
    }

}
