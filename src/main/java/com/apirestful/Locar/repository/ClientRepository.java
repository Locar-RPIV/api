package com.apirestful.Locar.repository;

import com.apirestful.Locar.model.Client;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
    
    Client findByCpf(String cpf);

    default void deleteByCpf(String cpf) {
        delete(findByCpf(cpf));
    }

    Client findById(int id);
}
