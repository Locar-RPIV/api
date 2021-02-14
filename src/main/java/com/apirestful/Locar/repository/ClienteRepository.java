package com.apirestful.Locar.repository;

import com.apirestful.Locar.model.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    
    Cliente findByCpf(long cpf);

    Cliente findByCpfAndCnh(Long cpf, Long cnh);
}
