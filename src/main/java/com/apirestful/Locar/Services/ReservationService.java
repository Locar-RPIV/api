package com.apirestful.Locar.Services;

import java.util.List;

import com.apirestful.Locar.model.Reservation;
import com.apirestful.Locar.model.User;
import com.apirestful.Locar.repository.AutomovelRepository;
import com.apirestful.Locar.repository.ClientRepository;
import com.apirestful.Locar.repository.ReservationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirestful.Locar.model.Automovel;
import com.apirestful.Locar.model.Client;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private AutomovelRepository autoRepository;

    public List<Reservation> findByUser(User user) {
        return reservationRepository.findByUser(user);
    }
    
    public Client findByCpf(String cpf) {
        return clientRepository.findByCpf(cpf);
    }

    public Automovel findByIdAutomovel(int id) {
        return autoRepository.findById(id);
    }

    public Reservation findById(int id) {
        return reservationRepository.findById(id);
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
