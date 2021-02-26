package com.apirestful.Locar.controller;

import java.util.List;

import com.apirestful.Locar.model.Funcionario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class FuncionarioController {

    @Autowired
    com.apirestful.Locar.repository.FuncionarioRepository funcionarioRepository;

    @GetMapping("/employer")
    public List<Funcionario> listFuncionarios() {
        return funcionarioRepository.findAll();
    }

    @GetMapping("/employer/{cpf}")
    public Funcionario cpfFuncionario(@PathVariable(value = "cpf") long cpf) {
        return funcionarioRepository.findByCpf(cpf);
    }

    @PostMapping("/employer")
    public Funcionario saveFuncionario(@RequestBody Funcionario funcionario) {
        funcionario.setAdmin(true);
        return funcionarioRepository.save(funcionario);
    }

    @DeleteMapping("/employer/{cpf}")
    public void deleteFuncionario(@PathVariable(value = "cpf") long cpf) {
        funcionarioRepository.deleteByCpf(cpf);
    }

    @PutMapping("/employer")
    public Funcionario refreshFuncionario(@RequestBody Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }
    
}