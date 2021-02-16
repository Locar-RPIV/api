package com.apirestful.Locar.repository;

import com.apirestful.Locar.model.Funcionario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

    Funcionario findById(int id);

    Funcionario findByCpf(Long cpf);

    Funcionario findByEmail(String email);

    Funcionario findByEmailAndSenha(String email, String senha);

    Funcionario findBySenha(String senha);
}
