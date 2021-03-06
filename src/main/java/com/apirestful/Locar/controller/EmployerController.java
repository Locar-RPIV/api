package com.apirestful.Locar.controller;

import java.util.List;

import com.apirestful.Locar.Services.EmployerService;
import com.apirestful.Locar.model.Employer;
import com.apirestful.Locar.model.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
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

    Response responseErro = new Response("Erro interno.");

    @GetMapping("/employer")
    public List<Employer> listFuncionarios() {
        return employerService.findAll();
    }

    @GetMapping("/employer/{cpf}")
    public Employer cpfFuncionario(@PathVariable(value = "cpf") String cpf) {
        return employerService.findByCpf(cpf);
    }

    @PostMapping("/employer")
    public Employer saveFuncionario(@RequestBody Employer employer) {
        String passwordCrypt = BCrypt.hashpw(employer.getPassword(), BCrypt.gensalt());
        employer.setPassword(passwordCrypt);
        employer.setAdmin(true);
        return employerService.save(employer);
    }

    @DeleteMapping("/employer/{cpf}")
    public <Any> Any deleteFuncionario(@PathVariable(value = "cpf") String cpf) {
        try {
            employerService.deleteByCpf(cpf);
            return (Any) new Response("Funcionário removido.");
        } catch (Exception e) {
            return (Any) responseErro;
        }
    }

    @PutMapping("/employer")
    public <Any> Any editFuncionario(@RequestBody Employer employer) {
        try {
            Employer updateEmployer = employerService.findById(employer.getId());
            if (employer.getCpf() != null) 
                updateEmployer.setCpf(employer.getCpf());
            if (employer.getNome() != null)
                updateEmployer.setNome(employer.getNome());
            if (employer.getTelefone() != null)
                updateEmployer.setTelefone(employer.getTelefone());
            if (employer.getDataNascimento() != null)
                updateEmployer.setDataNascimento(employer.getDataNascimento());
            if (employer.getEmail() != null)
                updateEmployer.setEmail(employer.getEmail());
            if  (employer.getPassword() != null) {
                String passwordCrypt = BCrypt.hashpw(employer.getPassword(), BCrypt.gensalt());
                employer.setPassword(passwordCrypt);
                updateEmployer.setPassword(employer.getPassword());
            }
            if (employer.getNumeroPis() != null)
                updateEmployer.setNumeroPis(employer.getNumeroPis());

            return (Any) employerService.save(updateEmployer);
        } catch (Exception e) {
            return (Any) responseErro;
        }
    }
    
}