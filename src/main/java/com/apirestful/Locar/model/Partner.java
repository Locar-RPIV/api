package com.apirestful.Locar.model;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * ClienteParceiro
 */
@Entity
public class Partner extends Client {

    @Column(unique = true, name = "rg", length = 9)
    private String rg;

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

}