package com.apirestful.Locar.Services;

import java.util.List;

import com.apirestful.Locar.model.Location;
import com.apirestful.Locar.model.Reservation;
import com.apirestful.Locar.repository.LocationRepository;
import com.apirestful.Locar.repository.ReservationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    public Reservation findByIdReservation(int id) {
        return reservationRepository.findById(id);
    }

    public Location findByReserva(Reservation reserva) {
        return locationRepository.findByReserva(reserva);
    }

    public Location findById(int id) {
        return locationRepository.findById(id);
    }

    public List<Location> findAll() {
        return locationRepository.findAll();
    }

    public Location save(Location l) {
        return locationRepository.save(l);
    }

    public void deleteById(int id) {
        locationRepository.deleteById(id);
    }
}
