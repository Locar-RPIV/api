package com.apirestful.Locar.controller;

import java.util.List;

import com.apirestful.Locar.Services.EmployerService;
import com.apirestful.Locar.model.Employer;
import com.apirestful.Locar.repository.EmployerRepository;

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
public class EmployerController {

    @Autowired
    EmployerService employerService;

    @Autowired
    EmployerRepository employerRepository;

    @GetMapping("/employer")
    public List<Employer> listFuncionarios() {
        return employerService.findAll();
    }

    @GetMapping("/employer/{cpf}")
    public Employer cpfFuncionario(@PathVariable(value = "cpf") long cpf) {
        return employerService.findByCpf(cpf);
    }

    @PostMapping("/employer")
    public Employer saveFuncionario(@RequestBody Employer employer) {
        employer.setAdmin(true);
        return employerService.save(employer);
    }

    // @PostMapping("/employer")
    // public Employer saveFuncionario(@RequestBody Employer employer) {
    //     employer.setAdmin(true);
    //     return employerRepository.save(employer);
    // }

    @DeleteMapping("/employer/{cpf}")
    public void deleteFuncionario(@PathVariable(value = "cpf") long cpf) {
        employerService.deleteByCpf(cpf);
    }

    @PutMapping("/employer")
    public Employer refreshFuncionario(@RequestBody Employer employer) {
        return employerService.save(employer);
    }
    
}