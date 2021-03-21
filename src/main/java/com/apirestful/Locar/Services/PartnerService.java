package com.apirestful.Locar.Services;

import java.util.List;

import com.apirestful.Locar.model.Partner;
import com.apirestful.Locar.model.Payment;
import com.apirestful.Locar.repository.PartnerRepository;
import com.apirestful.Locar.repository.PaymentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PartnerService {
    
    @Autowired
    PartnerRepository partnerRepository;
    
    @Autowired
    PaymentRepository paymentRepository;

    public Partner findByRg(int rg) {
        return partnerRepository.findByRg(rg);
    }

    public void deleteByRg(int rg) {
        partnerRepository.deleteByRg(rg);
    }

    public List<Partner> findAll() {
        return partnerRepository.findAll();
    }

    public Partner save(Partner partner) {
        return partnerRepository.save(partner);
    }

    public Payment save(Payment payment) {
        return paymentRepository.save(payment);
    }

}
