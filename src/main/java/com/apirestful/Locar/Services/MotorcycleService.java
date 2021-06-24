package com.apirestful.Locar.Services;

import java.util.List;

import com.apirestful.Locar.model.Motorcycle;
import com.apirestful.Locar.repository.MotorcycleRepository;

import org.springframework.beans.factory.annotation.Autowired;

public class MotorcycleService {
    @Autowired
    MotorcycleRepository motorcycleRepository;

    public Motorcycle findById(int id) {
        return motorcycleRepository.findById(id);
    }

    public List<Motorcycle> findByFilial(int filial) {
        return motorcycleRepository.findByFilial(filial);
    }

    public List<Motorcycle> findByModelo(String modelo) {
        return motorcycleRepository.findByModelo(modelo);
    }

    public List<Motorcycle> findByStatus(String status) {
        return motorcycleRepository.findByStatus(status);
    }
    
    public List<Motorcycle> findByCpfParceiro(String cpfParceiro) {
        return motorcycleRepository.findByCpfParceiro(cpfParceiro);
    }

    public List<Motorcycle> findAll() {
        return motorcycleRepository.findAll();
    }

    public Motorcycle save(Motorcycle motorcycle) {
        return motorcycleRepository.save(motorcycle);
    }

    public void deleteById(int id) {
        motorcycleRepository.deleteById(id);
    }
}
