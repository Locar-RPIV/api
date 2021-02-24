package com.apirestful.Locar.repository;

import com.apirestful.Locar.model.Funcionario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

    Funcionario findByCpf(Long cpf);
    
    default void deleteByCpf(long cpf) {
        delete(findByCpf(cpf));
    }
    
}
