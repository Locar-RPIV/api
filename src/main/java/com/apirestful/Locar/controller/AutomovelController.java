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

    @GetMapping("/automobile/{id}")
    public Automovel idAutomovel(@PathVariable(value = "id") int id){
        return automovelService.findById(id);
    }

    @GetMapping("/automobile/{idFilial}")
    public List<Automovel> AutomoveisFilial(@PathVariable(value = "idFilial") int idFilial){
        int automovelFilial = automovel.getFilial();
        if(idFilial == automovelFilial){
            return (List<Automovel>) automovelService.findById(idFilial);
        }else return null;
    }

    @GetMapping("/automobile/{modelo}")
    public Automovel modeloFilial(@PathVariable(value = "modelo") String modelo){
        if (modelo == automovel.getModelo()){
            return automovel;
        }else return null;
    }

    // @GetMapping("/automobile")
    // public Automovel modeloFilial(){
    //     automovel.getModelo();

    // }

    @PostMapping("/automobile")
    public Automovel saveAutomovel(@RequestBody Automovel automovel){
        if(automovel.iseDeParceiro() == true){
            automovel.seteDeParceiro(true);
        }
        automovelService.save(automovel);
        return automovel;
    }

    @DeleteMapping("/automobile")
    public void deleteAutomovel(@RequestBody Automovel automovel){
        automovelService.delete(automovel);
    }

    @PutMapping("/automobile")
    public Automovel refreshAutomovel(@RequestBody Automovel automovel){
        return automovelService.save(automovel);
    }
}