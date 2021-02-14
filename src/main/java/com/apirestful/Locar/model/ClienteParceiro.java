package com.apirestful.Locar.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * ClienteParceiro
 */
@Entity
@Table(name = "TB_CLIENTE_PARCEIRO")
public class ClienteParceiro extends Cliente {

    private static final long serialVersionUID = 1L;

    @Column(unique = true)
    private int rg;

    public int getRg() {
        return rg;
    }

    public void setRg(int rg) {
        this.rg = rg;
    }

}