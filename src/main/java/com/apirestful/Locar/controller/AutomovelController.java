package com.apirestful.Locar.controller;

import java.util.List;

import com.apirestful.Locar.Services.AutomovelService;
import com.apirestful.Locar.model.Automovel;
import com.apirestful.Locar.model.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SuppressWarnings("unchecked")
@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")
public class AutomovelController {

    @Autowired
    AutomovelService automovelService;
    private Automovel automovel;

    @GetMapping("/automobile")
    public <Any> Any listAutomoveis(){
        Response response = new Response();
        try {
            return (Any) automovelService.findAll();
        } catch (Exception e) {
            response.setMessage("Erro interno.");
            return (Any) new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
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
    
    @GetMapping("/automobile/{status}")
    public Automovel statusAutomovel(@PathVariable(value = "status") String status){
        if (status == automovel.getStatus()){
            return automovel;
        }else return null;
    }

    @PostMapping("/automobile")
    public <Any> Any saveAutomovel(@RequestBody Automovel automovel){
        Response response = new Response();
        try {
            automovelService.save(automovel);
            
        } catch (Exception e) {
            response.setMessage("Erro interno.");
            return (Any) new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return (Any) automovel;
    }

    @DeleteMapping("/automobile/{id}")
    public <Any> Any deleteAutomovel(@PathVariable(value = "id") int id){
        Response response = new Response();
        try {
            automovelService.deleteById(id);
            return (Any) new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            response.setMessage("Erro interno.");
            return (Any) new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/automobile")
    public <Any> Any refreshAutomovel(@RequestBody Automovel automovel){
        Response response = new Response();
        try {
            automovelService.save(automovel);
            return (Any) new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            response.setMessage("Erro interno.");
            return (Any) new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}