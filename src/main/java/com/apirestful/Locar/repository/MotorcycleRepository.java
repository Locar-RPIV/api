package com.apirestful.Locar.repository;

import java.util.List;

import com.apirestful.Locar.model.Motorcycle;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MotorcycleRepository extends JpaRepository<Motorcycle, Integer> {

    Motorcycle findById(int id);

    List<Motorcycle> findByCpfParceiro(String cpfParceiro);

    List<Motorcycle> findByFilial(int filial);

    List<Motorcycle> findByModelo(String modelo);

    List<Motorcycle> findByStatus(String status);

    Motorcycle findByPlaca(String placa);
    
    default void deleteById(int id){
        delete(findById(id));
    }
}
