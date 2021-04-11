package com.apirestful.Locar.Services;

import java.util.List;

import com.apirestful.Locar.model.User;
import com.apirestful.Locar.repository.ClientRepository;
import com.apirestful.Locar.repository.LocationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirestful.Locar.model.Client;
import com.apirestful.Locar.model.Location;

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private ClientRepository clientRepository;

    public List<Location> findByUser(User user) {
        return locationRepository.findByUser(user);
    }

    public Client findByCpf(long cpf) {
        return clientRepository.findByCpf(cpf);
    }

    public List<Location> findAll() {
        return locationRepository.findAll();
    }

    public Location save(Location l) {
        return locationRepository.save(l);
    }

    public void delete(Location l) {
    	locationRepository.delete(l);
    }

    public void deleteById(int id) {
        locationRepository.deleteById(id);
    }
}
