package com.apirestful.Locar.controller;

import java.util.List;

import com.apirestful.Locar.Services.ClientService;
import com.apirestful.Locar.model.Client;
import com.apirestful.Locar.model.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
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
public class ClientController {
    @Autowired
    ClientService clientService;

    Response responseErro = new Response("Erro interno.");

    @GetMapping("/client")
    public List<Client> listClientes() {
        List<Client> clients = clientService.findAll();
        return clients;
    }

    @GetMapping("/client/{cpf}")
    public <Any> Any cpfCliente(@PathVariable(value = "cpf") String cpf) {
        try {
            Client client = clientService.findByCpf(cpf);
            if (client != null) {
                return (Any) client;
            }
            return (Any) new Response("Cliente não encontrado.");
        } catch (Exception e) {
            return (Any) responseErro;
        }
    }

    @PostMapping("/client")
    public <Any> Any saveCliente(@RequestBody Client cliente) {
        try {
            String passwordCrypt = BCrypt.hashpw(cliente.getPassword(), BCrypt.gensalt());
            cliente.setPassword(passwordCrypt);
            cliente.setAdmin(false);
            cliente.setPartner(cliente.isPartner());
            return (Any) clientService.save(cliente);
        } catch (Exception e) {
            return (Any) responseErro;
        }
    }

    @DeleteMapping("/client/{cpf}")
    public <Any> Any deleteCliente(@PathVariable(value = "cpf") String cpf) { 
        try {
            clientService.deleteByCpf(cpf);
            return (Any) new Response("Cliente removido.");
        } catch (Exception e) {
            return (Any) responseErro;
        }

    }

    @PutMapping("/client")
    public <Any> Any editCliente(@RequestBody Client cliente) {
        try {
            Client updateClient = clientService.findById(cliente.getId());
            if (cliente.getCpf() != null) 
                updateClient.setCpf(cliente.getCpf());
            if (cliente.getNome() != null)
                updateClient.setNome(cliente.getNome());
            if (cliente.getTelefone() != null)
                updateClient.setTelefone(cliente.getTelefone());
            if (cliente.getDataNascimento() != null)
                updateClient.setDataNascimento(cliente.getDataNascimento());
            if (cliente.getEmail() != null)
                updateClient.setEmail(cliente.getEmail());
            if  (cliente.getPassword() != null) {
                String passwordCrypt = BCrypt.hashpw(cliente.getPassword(), BCrypt.gensalt());
                cliente.setPassword(passwordCrypt);
                updateClient.setPassword(cliente.getPassword());
            }
            if (cliente.getCnh() != null)
                updateClient.setCnh(cliente.getCnh());
            if (cliente.getIsPartner()) {
                updateClient.setPartner(cliente.getIsPartner());
            } else {
                updateClient.setPartner(false);
            }

            return (Any) clientService.save(updateClient);
        } catch (Exception e) {
            return (Any) responseErro;
        }
    }
}
