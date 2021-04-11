package com.apirestful.Locar.Services;

import java.util.List;

import com.apirestful.Locar.model.Reservation;
import com.apirestful.Locar.model.User;
import com.apirestful.Locar.repository.ClientRepository;
import com.apirestful.Locar.repository.ReservationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirestful.Locar.model.Client;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private ClientRepository clientRepository;

    public List<Reservation> findByUser(User user) {
        return reservationRepository.findByUser(user);
    }

    public Client findByCpf(long cpf) {
        return clientRepository.findByCpf(cpf);
    }

    public List<Reservation> findAll() {
        return reservationRepository.findAll();
    }

    public Reservation save(Reservation s) {
        return reservationRepository.save(s);
    }

    public void delete(Reservation s) {
        reservationRepository.delete(s);
    }

    public void deleteById(int id) {
        reservationRepository.deleteById(id);
    }
}
