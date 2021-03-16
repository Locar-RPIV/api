package com.apirestful.Locar.repository;

import java.util.List;

import com.apirestful.Locar.model.Client;
import com.apirestful.Locar.model.Reservation;
import com.apirestful.Locar.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long>{
    
    List<Reservation> findByUser(User user);

}
