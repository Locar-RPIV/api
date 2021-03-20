package com.apirestful.Locar.repository;

import java.util.List;

import com.apirestful.Locar.model.Automovel;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AutomovelRepository extends JpaRepository<Automovel, Integer>{
    Automovel findByid(int id);

    List<Automovel> findByCpfParceiro(long cpf);

    default void deleteById(int id){
        delete(findByid(id));
    }
}
