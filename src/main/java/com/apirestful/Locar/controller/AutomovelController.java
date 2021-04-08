package com.apirestful.Locar.controller;

import java.util.List;

import com.apirestful.Locar.Services.AutomovelService;
import com.apirestful.Locar.model.Automovel;

import org.springframework.beans.factory.annotation.Autowired;
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
public class AutomovelController {

    @Autowired
    AutomovelService automovelService;
    private Automovel automovel;

    @GetMapping("/automobile")
    public List<Automovel> listAutomoveis(){
        return automovelService.findAll();
    }

    @GetMapping("/automobile/partner/{cpfParceiro}")
    public List<Automovel> idAutomovel(@PathVariable(value = "cpfParceiro") long cpfParceiro){
        return automovelService.findByCpfParceiro(cpfParceiro);
    }

    @GetMapping("/automobile/{id}")
    public Automovel idAutomovel(@PathVariable(value = "id") int id){
        return automovelService.findById(id);
    }

    @GetMapping("/automobile/filial/{id}")
    public List<Automovel> AutomoveisFilial(@PathVariable(value = "id") int id){
        return automovelService.findByFilial(id);
    }
    
    @GetMapping("/automobile/modelo/{modelo}")
    public List<Automovel> modeloFilial(@PathVariable(value = "modelo") String modelo){
        return automovelService.findByModelo(modelo);
    }

    @PostMapping("/automobile")
    public Automovel saveAutomovel(@RequestBody Automovel automovel){
        automovelService.save(automovel);
        return automovel;
    }

    @DeleteMapping("/automobile/{id}")
    public void deleteAutomovel(@PathVariable(value = "id") int id){
        automovelService.deleteById(id);
    }

    @PutMapping("/automobile")
    public Automovel refreshAutomovel(@RequestBody Automovel automovel){
        return automovelService.save(automovel);
    }
}