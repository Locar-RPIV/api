package com.apirestful.Locar.repository;

import com.apirestful.Locar.model.Reserva;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    
    Reserva findByCpf(Long cpf);

}
