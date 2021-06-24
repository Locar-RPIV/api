package com.apirestful.Locar.repository;

import java.util.List;

import com.apirestful.Locar.model.Bus;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BusRepository extends JpaRepository<Bus, Integer> {
    Bus findById(int id);

    List<Bus> findByCpfParceiro(String cpfParceiro);

    List<Bus> findByFilial(int filial);

    List<Bus> findByModelo(String modelo);

    List<Bus> findByStatus(String status);

    Bus findByPlaca(String placa);
    
    default void deleteById(int id){
        delete(findById(id));
    }
}
