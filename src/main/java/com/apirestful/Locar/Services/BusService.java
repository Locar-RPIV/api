package com.apirestful.Locar.Services;

import java.util.List;

import com.apirestful.Locar.model.Bus;
import com.apirestful.Locar.repository.BusRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusService {
    @Autowired
    BusRepository busRepository;

    public Bus findById(int id) {
        return busRepository.findById(id);
    }

    public List<Bus> findByFilial(int filial) {
        return busRepository.findByFilial(filial);
    }

    public List<Bus> findByModelo(String modelo) {
        return busRepository.findByModelo(modelo);
    }

    public List<Bus> findByStatus(String status) {
        return busRepository.findByStatus(status);
    }
    
    public List<Bus> findByCpfParceiro(String cpfParceiro) {
        return busRepository.findByCpfParceiro(cpfParceiro);
    }

    public List<Bus> findAll() {
        return busRepository.findAll();
    }

    public Bus save(Bus bus) {
        return busRepository.save(bus);
    }

    public void deleteById(int id) {
        busRepository.deleteById(id);
    }
}
