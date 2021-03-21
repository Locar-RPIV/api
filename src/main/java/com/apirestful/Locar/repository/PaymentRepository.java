package com.apirestful.Locar.repository;

import com.apirestful.Locar.model.Partner;
import com.apirestful.Locar.model.Payment;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {

    Partner findById(int id);

}
