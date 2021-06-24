package com.apirestful.Locar.repository;

import java.util.List;

import com.apirestful.Locar.model.Car;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Integer> {
    Car findById(int id);

    List<Car> findByCpfParceiro(String cpfParceiro);

    List<Car> findByFilial(int filial);

    List<Car> findByModelo(String modelo);

    List<Car> findByStatus(String status);

    Car findByPlaca(String placa);
    
    default void deleteById(int id){
        delete(findById(id));
    }
}
