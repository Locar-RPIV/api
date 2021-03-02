package com.apirestful.Locar.controller;

import java.util.List;

import com.apirestful.Locar.model.Client;
import com.apirestful.Locar.repository.ClientRepository;

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
public class ClientController {

    @Autowired
    ClientRepository clienteRepository;

    @GetMapping("/client")
    public List<Client> listClientes() {
        return clienteRepository.findAll();
    }

    @GetMapping("/client/{cpf}")
    public Client cpfCliente(@PathVariable(value = "cpf") long cpf) {
        return clienteRepository.findByCpf(cpf);
    }

    @PostMapping("/client")
    public Client saveCliente(@RequestBody Client cliente) {
        cliente.setAdmin(false);
        return clienteRepository.save(cliente);
    }

    @DeleteMapping("/client/{cpf}")
    public void deleteCliente(@PathVariable(value = "cpf") long cpf) {
        clienteRepository.deleteByCpf(cpf);
    }

    @PutMapping("/client")
    public Client refreshCliente(@RequestBody Client cliente) {
        return clienteRepository.save(cliente);
    }
}
