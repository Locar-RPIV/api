package com.apirestful.Locar.Services;

import java.util.List;

import com.apirestful.Locar.model.Employer;
import com.apirestful.Locar.repository.EmployerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployerService {
    
    @Autowired
    EmployerRepository employerRepository;

    public Employer findByCpf(Long cpf) {
        return employerRepository.findByCpf(cpf);
    }

    public Employer findById(int id) {
        return employerRepository.findById(id);
    }

    public void deleteByCpf(Long cpf) {
        employerRepository.deleteByCpf(cpf);
    }

    public List<Employer> findAll() {
        return employerRepository.findAll();
    }

    public Employer save(Employer employer) {
        return employerRepository.save(employer);
    }
}
