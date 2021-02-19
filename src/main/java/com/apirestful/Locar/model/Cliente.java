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
public class Cliente extends User  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(unique = true)
    private long cnh;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getCnh() {
        return cnh;
    }

    public void setCnh(long cnh) {
        this.cnh = cnh;
    }

    // public Cliente(int id, long cpf, String nome, String telefone, Date dataNascimento, String email, String password,
    //         int id2, long cnh, boolean admin) {
    //     super(id, cpf, nome, telefone, dataNascimento, email, password);
    //     id = id2;
    //     this.cnh = cnh;
    //     this.admin = admin;
    // }

}