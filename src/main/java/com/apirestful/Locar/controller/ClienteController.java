package com.apirestful.Locar.controller;

import java.util.List;

import com.apirestful.Locar.model.Cliente;
import com.apirestful.Locar.repository.ClienteRepository;

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
@RequestMapping(value = "/api/funcionario")
public class ClienteController {

    @Autowired
    ClienteRepository clienteRepository;

    @GetMapping("/todosClientes")
    public List<Cliente> listClientes() {
        return clienteRepository.findAll();
    }

    @GetMapping("/todosCliente/{cpf}")
    public Cliente cpfCliente(@PathVariable(value = "cpf") long cpf) {
        return clienteRepository.findByCpf(cpf);
    }

    @PostMapping("/inserirCliente")
    public Cliente saveCliente(@RequestBody Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @DeleteMapping("/apagarCliente")
    public void deleteCliente(@RequestBody Cliente cliente) {
        clienteRepository.delete(cliente);
    }

    @PutMapping("/editarCliente")
    public Cliente refreshCliente(@RequestBody Cliente cliente) {
        return clienteRepository.save(cliente);
    }
}
