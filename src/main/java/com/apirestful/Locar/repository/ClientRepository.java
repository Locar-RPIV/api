package com.apirestful.Locar.repository;

import com.apirestful.Locar.model.Client;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
    
    Client findByCpf(long cpf);

    default void deleteByCpf(long cpf) {
        delete(findByCpf(cpf));
    }
}
