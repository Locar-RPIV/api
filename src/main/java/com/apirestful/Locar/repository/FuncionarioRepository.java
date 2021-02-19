package com.apirestful.Locar.repository;

import com.apirestful.Locar.model.Funcionario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

    Funcionario findById(int id);

    Funcionario findByCpf(Long cpf);

    Funcionario findByEmailAndPassword(String email, String password);

    Funcionario findByEmail(String email);

    Funcionario findByPassword(String password);

}
