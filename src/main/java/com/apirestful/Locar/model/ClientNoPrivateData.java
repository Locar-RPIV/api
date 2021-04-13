package com.apirestful.Locar.model;

import java.util.Date;

public class ClientNoPrivateData {
    int id;
    long cnh;
    boolean isPartner;
    boolean admin;
    long cpf;
    String nome;
    String telefone;
    Date dataNascimento;
    int pontosFidelidade;
    public ClientNoPrivateData(int id, long cnh, boolean isPartner, long cpf, String nome, String telefone,
            Date dataNascimento, int pontosFidelidade) {
        this.id = id;
        this.cnh = cnh;
        this.isPartner = isPartner;
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        this.pontosFidelidade = pontosFidelidade;
    }
    public ClientNoPrivateData(int id, long cpf, String nome, String telefone,
    Date dataNascimento, int pontosFidelidade) {
        this.id = id;
        this.cnh = cnh;
        this.isPartner = isPartner;
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        this.pontosFidelidade = pontosFidelidade;
        }
}