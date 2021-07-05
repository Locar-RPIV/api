package com.apirestful.Locar.controller;

import java.util.List;

import com.apirestful.Locar.Services.ReservationService;
import com.apirestful.Locar.model.Automovel;
import com.apirestful.Locar.model.Reservation;
import com.apirestful.Locar.model.Response;
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

    @GetMapping(value = "/reservation")
    public List<Reservation> listReservas() {
        return reservaService.findAll();
    }

    @GetMapping(value = "/reservation/{cpf}")
    public List<Reservation> cpfReserva(@PathVariable(value = "cpf") String cpf) {
        User user = reservaService.findByCpf(cpf);
        return reservaService.findByUser(user);
    }

    @PostMapping(value = "/reservation")
    public <Any> Any saveReserva(@RequestBody Reservation reserva) {
        String clientCpf = reserva.getUser().getCpf();
        User user = reservaService.findByCpf(clientCpf);
        reserva.setUser(user);
        int autoId = reserva.getVeiculo().getId();
        Automovel auto = reservaService.findByIdAutomovel(autoId);
        if (auto.getStatus().toLowerCase().equals("indisponível")
                || auto.getStatus().toLowerCase().equals("manutenção")) {
            return (Any) new Response("Veiculo indisponível no momento.");
        }
        reserva.setVeiculo(auto);
        return (Any) reservaService.save(reserva);
    }

    @PutMapping(value = "/reservation")
    public <Any> Any editReserva(@RequestBody Reservation reserva) {
        try {
            Reservation updateReservation = reservaService.findById(reserva.getId());
            if (reserva.getUser() != null) {
                String clientCpf = reserva.getUser().getCpf();
                User user = reservaService.findByCpf(clientCpf);
                reserva.setUser(user);
                updateReservation.setUser(reserva.getUser());
            }
            if (reserva.getVeiculo() != null) {
                int autoId = reserva.getVeiculo().getId();
                Automovel auto = reservaService.findByIdAutomovel(autoId);
                reserva.setVeiculo(auto);
                updateReservation.setVeiculo(reserva.getVeiculo());
            }
            if (reserva.getDataRetirada() != null)
                updateReservation.setDataRetirada(reserva.getDataRetirada());

            return (Any) reservaService.save(updateReservation);
        } catch (Exception e) {
            return (Any) new Response("Erro ao alterar reserva.");
        }
    }

    @DeleteMapping(value = "/reservation/{id}")
    public <Any> Any deleteReserva(@PathVariable(value = "id") int id) {
        try {
            reservaService.deleteById(id);
            return (Any) new Response("Reserva apagada.");
        } catch (Exception e) {
            return (Any) new Response("Erro ao apagar reserva.");
        }
    }

}
