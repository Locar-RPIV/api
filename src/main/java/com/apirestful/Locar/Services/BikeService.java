package com.apirestful.Locar.Services;

import java.util.List;

import com.apirestful.Locar.model.Bike;
import com.apirestful.Locar.repository.BikeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BikeService {
    
    @Autowired
    BikeRepository bikeRepository;

    public Bike findById(int id) {
        return bikeRepository.findById(id);
    }

    public List<Bike> findByFilial(int filial) {
        return bikeRepository.findByFilial(filial);
    }

    public List<Bike> findByModelo(String modelo) {
        return bikeRepository.findByModelo(modelo);
    }

    public List<Bike> findByStatus(String status) {
        return bikeRepository.findByStatus(status);
    }
    
    public List<Bike> findByCpfParceiro(String cpfParceiro) {
        return bikeRepository.findByCpfParceiro(cpfParceiro);
    }

    public List<Bike> findAll() {
        return bikeRepository.findAll();
    }

    public Bike save(Bike bike) {
        return bikeRepository.save(bike);
    }

    public void deleteById(int id) {
        bikeRepository.deleteById(id);
    }
}
