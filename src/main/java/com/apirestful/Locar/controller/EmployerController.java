package com.apirestful.Locar.controller;

import java.util.List;

import com.apirestful.Locar.Services.EmployerService;
import com.apirestful.Locar.model.Employer;
import com.apirestful.Locar.model.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin(origins = "*")
public class EmployerController {

    @Autowired
    EmployerService employerService;

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

    @DeleteMapping("/employer/{cpf}")
    public <Any> Any deleteFuncionario(@PathVariable(value = "cpf") long cpf) {
        Response response = new Response();
        try {
            employerService.deleteByCpf(cpf);
            return (Any) new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            response.setMessage("Erro interno");
            return (Any) new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/employer")
    public Employer refreshFuncionario(@RequestBody Employer employer) {
        return employerService.save(employer);
    }
    
}