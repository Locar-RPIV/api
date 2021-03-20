package com.apirestful.Locar.controller;

import java.util.List;

import com.apirestful.Locar.Services.PartnerService;
import com.apirestful.Locar.model.Client;
import com.apirestful.Locar.model.Partner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")
public class PartnerController {

    @Autowired
    PartnerService partnerService;

    @GetMapping("/partner")
    public List<Partner> listClientes() {
        return partnerService.findAll();
    }

    @GetMapping("/partner/{rg}")
    public Client cpfCliente(@PathVariable(value = "rg") int rg) {
        return partnerService.findByRg(rg);
    }

    @PostMapping("/partner")
    public Partner saveCliente(@RequestBody Partner partner) {
        partner.setAdmin(false);
        return partnerService.save(partner);
    }

    @DeleteMapping("/partner/{rg}")
    public void deleteCliente(@PathVariable(value = "rg") int rg) {
        partnerService.deleteByRg(rg);
    }

    @PutMapping("/partner")
    public Partner refreshClienteParceiro(@RequestBody Partner partner) {
        return partnerService.save(partner);
    }
}
