package com.apirestful.Locar.controller;

import java.util.List;

import com.apirestful.Locar.Services.ClientService;
import com.apirestful.Locar.model.Client;

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
public class ClientController {

    @Autowired
    ClientService clientService;

    @GetMapping("/client")
    public List<Client> listClientes() {
        return clientService.findAll();
    }

    @GetMapping("/client/{cpf}")
    public Client cpfCliente(@PathVariable(value = "cpf") long cpf) {
        return clientService.findByCpf(cpf);
    }

    @GetMapping("/client/points/{id}")
    public Client pointsClient(@PathVariable(value = "id") int id) {
        return clientService.findById(id);
    }

    @PostMapping("/client")
    public Client saveCliente(@RequestBody Client cliente) {
        cliente.setAdmin(false);
        return clientService.save(cliente);
    }

    @DeleteMapping("/client/{cpf}")
    public void deleteCliente(@PathVariable(value = "cpf") long cpf) {
        clientService.deleteByCpf(cpf);
    }

    @PutMapping("/client")
    public Client refreshCliente(@RequestBody Client cliente) {
        return clientService.save(cliente);
    }
}
