package com.apirestful.Locar.Services;

import java.util.List;

import com.apirestful.Locar.model.Automovel;
import com.apirestful.Locar.repository.AutomovelRepository;

import com.apirestful.Locar.repository.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutomovelService {
    
    @Autowired
    AutomovelRepository automovelRepository;

    public Automovel findById(int id) {
        return automovelRepository.findByid(id);
    }

    public List<Automovel> findAll() {
        return automovelRepository.findAll();
    }

    public Automovel save(Automovel automovel) {
        return automovelRepository.save(automovel);
    }

    public void delete(Automovel automovel) {
        automovelRepository.delete(automovel);
    }
}
