package com.apirestful.Locar.model;

import java.util.Date;

public class ClientNoPrivateData {
    int id;
    String cnh;
    boolean isPartner;
    boolean admin;
    String cpf;
    String nome;
    String telefone;
    Date dataNascimento;
    int pontosFidelidade;
    public ClientNoPrivateData(int id, String cnh, boolean isPartner, String cpf, String nome, String telefone,
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
    public ClientNoPrivateData(int id, String cpf, String nome, String telefone,
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