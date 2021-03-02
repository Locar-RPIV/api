package com.apirestful.Locar.repository;

import com.apirestful.Locar.model.Partner;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PartnerRepository extends JpaRepository<Partner, Long> {

    Partner findByRg(int rg);

    default void deleteByRg(int rg) {
        delete(findByRg(rg));
    }
    
}
