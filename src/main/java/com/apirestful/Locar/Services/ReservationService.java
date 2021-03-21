package com.apirestful.Locar.Services;

import java.util.List;

import com.apirestful.Locar.model.Reservation;
import com.apirestful.Locar.model.User;
import com.apirestful.Locar.repository.ReservationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> findByUser(User user) {
        return reservationRepository.findByUser(user);
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
}
