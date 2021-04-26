package com.apirestful.Locar.repository;

import com.apirestful.Locar.model.Location;
import com.apirestful.Locar.model.Reservation;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long>{

    Location findById(int id);

    Location findByReserva(Reservation reserva);

    default void deleteById(int id) {
        delete(findById(id));
    }
}
