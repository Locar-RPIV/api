package com.apirestful.Locar.Services;

import java.util.List;

import com.apirestful.Locar.model.Client;
import com.apirestful.Locar.repository.ClientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    
    @Autowired
    ClientRepository clientRepository;

    public Client findByCpf(String cpf) {
        return clientRepository.findByCpf(cpf);
    }

    public void deleteByCpf(String cpf) {
        clientRepository.deleteByCpf(cpf);
    }

    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    public Client save(Client client) {
        return clientRepository.save(client);
    }

    public Client findById(int id) {
        return clientRepository.findById(id);
    }
}
