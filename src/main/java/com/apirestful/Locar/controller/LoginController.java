package com.apirestful.Locar.controller;

import com.apirestful.Locar.model.Funcionario;
import com.apirestful.Locar.repository.FuncionarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class LoginController {

    @Autowired
    FuncionarioRepository funcionarioRepository;

    
    @PostMapping("/login")
    public Funcionario loginFuncionario(@RequestBody Funcionario funcionario) {
        return funcionarioRepository.findByEmailAndSenha(funcionario.getEmail(), funcionario.getSenha());
    }

    
}
