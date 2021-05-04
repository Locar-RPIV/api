package com.apirestful.Locar.Services;

import java.util.List;

import com.apirestful.Locar.model.Automovel;
import com.apirestful.Locar.repository.AutomovelRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutomovelService {
    
    @Autowired
    AutomovelRepository automovelRepository;

    public Automovel findById(int id) {
        return automovelRepository.findById(id);
    }

    public List<Automovel> findByFilial(int filial) {
        return automovelRepository.findByFilial(filial);
    }

    public List<Automovel> findByModelo(String modelo) {
        return automovelRepository.findByModelo(modelo);
    }

    public List<Automovel> findByStatus(String status) {
        return automovelRepository.findByStatus(status);
    }
    
    public List<Automovel> findByCpfParceiro(String cpfParceiro) {
        return automovelRepository.findByCpfParceiro(cpfParceiro);
    }

    public List<Automovel> findAll() {
        return automovelRepository.findAll();
    }

    public Automovel save(Automovel automovel) {
        return automovelRepository.save(automovel);
    }

    public void deleteById(int id) {
        automovelRepository.deleteById(id);
    }
}
