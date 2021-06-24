package com.apirestful.Locar.Services;

import java.util.List;

import com.apirestful.Locar.model.Car;
import com.apirestful.Locar.repository.CarRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService {
    @Autowired
    CarRepository carRepository;

    public Car findById(int id) {
        return carRepository.findById(id);
    }

    public List<Car> findByFilial(int filial) {
        return carRepository.findByFilial(filial);
    }

    public List<Car> findByModelo(String modelo) {
        return carRepository.findByModelo(modelo);
    }

    public List<Car> findByStatus(String status) {
        return carRepository.findByStatus(status);
    }
    
    public List<Car> findByCpfParceiro(String cpfParceiro) {
        return carRepository.findByCpfParceiro(cpfParceiro);
    }

    public List<Car> findAll() {
        return carRepository.findAll();
    }

    public Car save(Car car) {
        return carRepository.save(car);
    }

    public void deleteById(int id) {
        carRepository.deleteById(id);
    }
}
