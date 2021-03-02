package com.apirestful.Locar.controller;

import com.apirestful.Locar.model.Automovel;
import com.apirestful.Locar.repository.AutomovelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class AutomovelController {

    @Autowired
    AutomovelRepository automovelRepository;
    private Automovel automovel;

    @GetMapping("/automobile")
    public List<Automovel> listAutomoveis(){
        return automovelRepository.findAll();
    }

    @GetMapping("/automobile/{id}")
    public Automovel idAutomovel(@PathVariable(value = "id") int id){
        return automovelRepository.findByid(id);
    }

    @PostMapping("/automobile")
    public Automovel saveAutomovel(@RequestBody Automovel automovel){

        List<Automovel> listAutos = automovelRepository.findAll();
        return automovelRepository.save(automovel);
    }

    @DeleteMapping("/automobile")
    public void deleteAutomovel(@RequestBody Automovel automovel){
        automovelRepository.delete(automovel);
    }

    @PutMapping("/automobile")
    public Automovel refreshAutomovel(@RequestBody Automovel automovel){
        return automovelRepository.save(automovel);
    }
}
