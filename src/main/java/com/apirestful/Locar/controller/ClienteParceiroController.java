package com.apirestful.Locar.controller;

import java.util.List;

import com.apirestful.Locar.model.Cliente;
import com.apirestful.Locar.model.ClienteParceiro;
import com.apirestful.Locar.repository.ClienteParceiroRepository;

import org.springframework.beans.factory.annotation.Autowired;
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
public class ClienteParceiroController {

    @Autowired
    ClienteParceiroRepository clienteParceiroRepository;

    @GetMapping("/partner")
    public List<ClienteParceiro> listClientes() {
        return clienteParceiroRepository.findAll();
    }

    @GetMapping("/partner/{rg}")
    public Cliente cpfCliente(@PathVariable(value = "rg") int rg) {
        return clienteParceiroRepository.findByRg(rg);
    }

    @PostMapping("/partner")
    public ClienteParceiro saveCliente(@RequestBody ClienteParceiro clienteParceiro) {
        clienteParceiro.setAdmin(false);
        return clienteParceiroRepository.save(clienteParceiro);
    }

    @DeleteMapping("/partner/{rg}")
    public void deleteCliente(@PathVariable(value = "rg") int rg) {
        clienteParceiroRepository.deleteByRg(rg);
    }

    @PutMapping("/partner")
    public ClienteParceiro refreshClienteParceiro(@RequestBody ClienteParceiro clienteParceiro) {
        return clienteParceiroRepository.save(clienteParceiro);
    }
}
