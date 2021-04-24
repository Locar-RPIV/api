package com.apirestful.Locar.repository;

import com.apirestful.Locar.model.Employer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployerRepository extends JpaRepository<Employer, Long> {

    Employer findByCpf(String cpf);
    
    default void deleteByCpf(String cpf) {
        delete(findByCpf(cpf));
    }

    Employer findById(int id);
}
