package com.apirestful.Locar.repository;

import java.util.List;

import com.apirestful.Locar.model.Automovel;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AutomovelRepository extends JpaRepository<Automovel, Integer>{

    Automovel findById(int id);

    List<Automovel> findByCpfParceiro(String cpfParceiro);

    List<Automovel> findByFilial(int filial);

    List<Automovel> findByModelo(String modelo);

    List<Automovel> findByStatus(String status);

    Automovel findByPlaca(String placa);
    
    default void deleteById(int id){
        delete(findById(id));
    }
}
