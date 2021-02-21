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

    @GetMapping("/todosFuncionarios")
    public List<Funcionario> listFuncionarios() {
        return funcionarioRepository.findAll();
    }

    // @GetMapping("/funcionarios/{id}")
    // public Funcionario Funcionario(@PathVariable(value = "id") int id) {
    // return funcionarioRepository.findById(id);
    // }

    @GetMapping("/todosFuncionarios/{cpf}")
    public Funcionario cpfFuncionario(@PathVariable(value = "cpf") long cpf) {
        return funcionarioRepository.findByCpf(cpf);
    }

    @PostMapping("/inserirFuncionario")
    public Funcionario saveFuncionario(@RequestBody Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    @DeleteMapping("/apagarFuncionario")
    public void deleteFuncionario(@RequestBody Funcionario funcionario) {
        funcionarioRepository.delete(funcionario);
    }

    @PutMapping("/editarFuncionario")
    public Funcionario refreshFuncionario(@RequestBody Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }
    
}