package com.apirestful.Locar.repository;

import java.util.List;

import com.apirestful.Locar.model.Location;
import com.apirestful.Locar.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long>{
    
    List<Location> findByUser(User user);

    Location findById(int id);

    default void deleteById(int id) {
        delete(findById(id));
    }
}
