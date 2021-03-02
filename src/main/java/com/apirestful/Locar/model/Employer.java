package com.apirestful.Locar.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Funcionario
 */
@Entity
public class Employer extends User  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_funcionario")
    private int id;

    @Column(unique = true, name = "numeroPis", length = 11)
    private long numeroPis;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getNumeroPis() {
        return numeroPis;
    }

    public void setNumeroPis(long numeroPis) {
        this.numeroPis = numeroPis;
    }

    // public Funcionario(int id, long cpf, String nome, String telefone, Date dataNascimento, String email,
    //         String password, int id2, long numeroPis, boolean admin) {
    //     super(id, cpf, nome, telefone, dataNascimento, email, password);
    //     id = id2;
    //     this.numeroPis = numeroPis;
    //     this.admin = admin;
    // }

}