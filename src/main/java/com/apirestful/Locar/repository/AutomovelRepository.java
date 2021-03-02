package com.apirestful.Locar.repository;

import com.apirestful.Locar.model.Automovel;
import com.apirestful.Locar.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AutomovelRepository extends JpaRepository<Automovel, Integer>{
    Automovel findByid(int id);

    default void deleteById(int id){
        delete(findByid(id));
    }
}
