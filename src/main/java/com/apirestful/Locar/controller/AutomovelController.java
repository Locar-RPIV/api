package com.apirestful.Locar.controller;

import com.apirestful.Locar.model.Automovel;
import com.apirestful.Locar.repository.AutomovelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/automovel")
public class AutomovelController {

    @Autowired
    AutomovelRepository automovelRepository;

    @GetMapping("/getAutomoveis")
    public List<Automovel> listAutomoveis(){
        return automovelRepository.findAll();
    }

    @GetMapping("/Automovel/{id}")
    public Automovel idAutomovel(@PathVariable(value = "id") int id){
        return automovelRepository.findByid(id);
    }

    @PostMapping("/automovel")
    public Automovel saveAutomovel(@RequestBody Automovel automovel){
        return automovelRepository.save(automovel);
    }

    @DeleteMapping("/automovel")
    public void deleteAutomovel(@RequestBody Automovel automovel){
        automovelRepository.delete(automovel);
    }

    @PutMapping("/automovel")
    public Automovel refreshAutomovel(@RequestBody Automovel automovel){
        return automovelRepository.save(automovel);
    }

    @GetMapping("/detalhesautomovel")
    public Automovel detalhesAutomovel(@RequestBody Automovel automovel){
        automovel.getId();
        automovel.getMarca();
        automovel.getModelo();
        automovel.getPotencia();
        automovel.getAno();
        automovel.getQuilometragem();
        automovel.getValorLocacao();

        return automovel;
    }

}
