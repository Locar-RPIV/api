package com.apirestful.Locar.repository;

import com.apirestful.Locar.model.Employer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployerRepository extends JpaRepository<Employer, Long> {

    Employer findByCpf(Long cpf);
    
    default void deleteByCpf(long cpf) {
        delete(findByCpf(cpf));
    }
}
