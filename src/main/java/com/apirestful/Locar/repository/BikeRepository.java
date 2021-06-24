package com.apirestful.Locar.repository;

import java.util.List;

import com.apirestful.Locar.model.Bike;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BikeRepository extends JpaRepository<Bike, Integer> {
    
    Bike findById(int id);

    List<Bike> findByCpfParceiro(String cpfParceiro);

    List<Bike> findByFilial(int filial);

    List<Bike> findByModelo(String modelo);

    List<Bike> findByStatus(String status);

    Bike findByPlaca(String placa);
    
    default void deleteById(int id){
        delete(findById(id));
    }
}
