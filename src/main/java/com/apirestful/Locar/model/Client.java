package com.apirestful.Locar.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Cliente
 */
@Entity
public class Client extends User  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_client")
    private int id;

    @Column(unique = true, name = "cnh", length = 11)
    private String cnh;

    @Column(name = "isPartner")
    private boolean isPartner;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    public void setPartner(boolean partner) {
        this.isPartner = partner;
    }

    public boolean getIsPartner() {
        return isPartner;
    }

    public boolean isPartner() {
        return isPartner;
    }

}