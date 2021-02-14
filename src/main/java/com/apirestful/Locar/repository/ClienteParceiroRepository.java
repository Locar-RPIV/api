package com.apirestful.Locar.repository;

import com.apirestful.Locar.model.ClienteParceiro;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteParceiroRepository extends JpaRepository<ClienteParceiro, Long> {

    ClienteParceiro findByRg(int rg);
}
