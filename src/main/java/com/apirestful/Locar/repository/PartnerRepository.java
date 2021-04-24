package com.apirestful.Locar.repository;

import com.apirestful.Locar.model.Partner;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PartnerRepository extends JpaRepository<Partner, Long> {

    Partner findByRg(String rg);

    default void deleteByRg(String rg) {
        delete(findByRg(rg));
    }

    Partner findById(int id);
    
}
