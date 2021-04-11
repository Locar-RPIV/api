package com.apirestful.Locar.controller;

import java.util.List;

import com.apirestful.Locar.Services.ClientService;
import com.apirestful.Locar.model.Client;
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
public class ClientController {

    @Autowired
    ClientService clientService;

    @GetMapping("/client")
    public List<Client> listClientes() {
        List<Client> clients = clientService.findAll();
        for (Client client : clients) {
            client.setEmail("private data");
            client.setPassword("private data");
        }
        return clients;
    }

    @GetMapping("/client/{cpf}")
    public <Any> Any cpfCliente(@PathVariable(value = "cpf") long cpf) {
        Response response = new Response();
        try {
            Client client = clientService.findByCpf(cpf);
            if (client != null) {
                return (Any) client;
            }
            response.setMessage("Cliente nao encontrado");
            return (Any) new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            response.setMessage("Erro interno.");
            return (Any) new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/client/points/{id}")
    public Client pointsClient(@PathVariable(value = "id") int id) {
        return clientService.findById(id);
    }

    @PostMapping("/client")
    public <Any> Any saveCliente(@RequestBody Client cliente) {
        Response response = new Response();
        try {
            cliente.setAdmin(false);
            cliente.setPartner(cliente.isPartner());
            Client client = clientService.save(cliente);
            client.setEmail("private data");
            client.setPassword("private data");
            return (Any) client;
        } catch (Exception e) {
            response.setMessage("Erro interno.");
            return (Any) new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/client/{cpf}")
    public <Any> Any deleteCliente(@PathVariable(value = "cpf") long cpf) {
        Response response = new Response();
        try {
            clientService.deleteByCpf(cpf);
            return (Any) new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            response.setMessage("Erro interno");
            return (Any) new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping("/client")
    public <Any> Any refreshCliente(@RequestBody Client cliente) {
        Response response = new Response();
        try {
            Client updateClient = clientService.findById(cliente.getId());
            if (cliente.getCpf() > 0) 
                updateClient.setCpf(cliente.getCpf());
            if (cliente.getNome() != null)
                updateClient.setNome(cliente.getNome());
            if (cliente.getTelefone() != null)
                updateClient.setTelefone(cliente.getTelefone());
            if (cliente.getDataNascimento() != null)
                updateClient.setDataNascimento(cliente.getDataNascimento());
            if (cliente.getEmail() != null)
                updateClient.setEmail(cliente.getEmail());
            if  (cliente.getPassword() != null)
                updateClient.setPassword(cliente.getPassword());
            if (cliente.getPontosFidelidade() >= 0)
                updateClient.setPontosFidelidade(cliente.getPontosFidelidade());
            if (cliente.getCnh() >= 0)
                updateClient.setCnh(cliente.getCnh());
            if (cliente.getIsPartner()) {
                updateClient.setPartner(cliente.getIsPartner());
            } else {
                updateClient.setPartner(false);
            }

            clientService.save(updateClient);
            return (Any) new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            response.setMessage("Erro interno.");
            return (Any) new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }
}
