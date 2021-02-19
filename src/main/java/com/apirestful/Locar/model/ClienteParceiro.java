package com.apirestful.Locar.model;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * ClienteParceiro
 */
@Entity
public class ClienteParceiro extends Cliente {

    @Column(unique = true)
    private int rg;

    public int getRg() {
        return rg;
    }

    public void setRg(int rg) {
        this.rg = rg;
    }

    // public ClienteParceiro(int id, long cpf, String nome, String telefone, Date dataNascimento, String email,
    //         String password, int id2, long cnh, boolean admin, int rg) {
    //     super(id, cpf, nome, telefone, dataNascimento, email, password, id2, cnh, admin);
    //     this.rg = rg;
    // }


}