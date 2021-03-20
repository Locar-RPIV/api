package com.apirestful.Locar.model;

import org.springframework.lang.NonNull;

import javax.persistence.*;

/**
 * Filial
 */
@Entity
@Table(name = "TB_FILIAL")
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NonNull
    private String nome;

    @NonNull
    private long cnpj;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public String getNome() {
        return nome;
    }

    public void setNome(@NonNull String nome) {
        this.nome = nome;
    }

    public long getCnpj() {
        return cnpj;
    }

    public void setCnpj(long cnpj) {
        this.cnpj = cnpj;
    }
}
