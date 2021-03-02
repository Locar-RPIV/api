package com.apirestful.Locar.Services;

import com.apirestful.Locar.model.Client;
import com.apirestful.Locar.repository.ClientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    
    @Autowired
    ClientRepository clientRepository;

    public Client findByCpf(Long cpf) {
        return clientRepository.findByCpf(cpf);
    }

    public void deleteByCpf(Long cpf) {
        clientRepository.deleteByCpf(cpf);
    }
}
