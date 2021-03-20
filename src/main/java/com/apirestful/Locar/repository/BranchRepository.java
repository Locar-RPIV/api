package com.apirestful.Locar.repository;

import com.apirestful.Locar.model.Branch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BranchRepository extends JpaRepository<Branch, Integer> {
    Branch findById(int id);

    default void deleteById(int id){
        delete(findById(id));
    }

}
