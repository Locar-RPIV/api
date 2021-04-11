package com.apirestful.Locar.repository;

import java.util.List;

import com.apirestful.Locar.model.Reservation;
import com.apirestful.Locar.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

import net.bytebuddy.asm.Advice.Return;

public interface ReservationRepository extends JpaRepository<Reservation, Long>{
    
    List<Reservation> findByUser(User user);

    Reservation findById(int id);

    default void deleteById(int id) {
        delete(findById(id));
    }
}
