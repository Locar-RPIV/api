package com.apirestful.Locar.controller;

import java.util.List;

import com.apirestful.Locar.Services.LocationService;
import com.apirestful.Locar.model.Location;
import com.apirestful.Locar.model.User;

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
public class LocationController {
    
    @Autowired
    LocationService LocacaoService;

    @GetMapping(value="/location")
    public List<Location> listLocacoes() {
        return LocacaoService.findAll();
    }
    
    @GetMapping(value="/location/{cpf}")
    public List<Location> cpfLocacao(@PathVariable(value = "cpf") int cpf) {

        User user = LocacaoService.findByCpf(cpf);

        return LocacaoService.findByUser(user);
    }
    
    @PostMapping(value="/location")
    public Location saveLocacao(@RequestBody Location locacao) {
        long clientCpf = locacao.getUser().getCpf();
        User user = LocacaoService.findByCpf(clientCpf);
        locacao.setUser(user);
        return LocacaoService.save(locacao);
    }
    
    @PutMapping(value="/location")
    public Location editLocacao(@RequestBody Location locacao) {        
        return LocacaoService.save(locacao);
    }

    @DeleteMapping(value = "/location")
    public void deleteLocacao(@RequestBody Location locacao) {
        LocacaoService.delete(locacao);
    }

}
