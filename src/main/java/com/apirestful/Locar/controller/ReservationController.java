package com.apirestful.Locar.controller;

import java.util.List;

import com.apirestful.Locar.Services.ReservationService;
import com.apirestful.Locar.model.Reservation;
import com.apirestful.Locar.model.User;

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
public class ReservationController {
    
    @Autowired
    ReservationService reservaService;

    @GetMapping(value="/reservation")
    public List<Reservation> listReservas() {
        return reservaService.findAll();
    }
    
    @GetMapping(value="/reservation/{cpf}")
    public List<Reservation> cpfReserva(@PathVariable(value = "cpf") int cpf) {

        User user = reservaService.findByCpf(cpf);

        return reservaService.findByUser(user);
    }
    
    @PostMapping(value="/reservation")
    public Reservation saveReserva(@RequestBody Reservation reserva) {
        long clientCpf = reserva.getUser().getCpf();
        User user = reservaService.findByCpf(clientCpf);
        reserva.setUser(user);
        return reservaService.save(reserva);
    }
    
    @PutMapping(value="/reservation")
    public Reservation editReserva(@RequestBody Reservation reserva) {        
        return reservaService.save(reserva);
    }

    @DeleteMapping(value = "/reservation")
    public void deleteReserva(@RequestBody Reservation reserva) {
        reservaService.delete(reserva);
    }

}
