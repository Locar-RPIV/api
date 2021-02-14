package com.apirestful.Locar.model;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TB_AUTOMOVEIS")
public class Automovel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NonNull
    private String placa;

    @NonNull
    private String cor;

    @NonNull
    private int ano;

    @NonNull
    private int tipoCombustivel;

    @NonNull
    private int numeroPortas;

    @NonNull
    private long quilometragem;

    @NonNull
    private long renavan;

    @NonNull
    private String chassi;

    @NonNull
    private double valorLocacao;

    @NonNull
    private boolean eDeParceiro;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(@NonNull String placa) {
        this.placa = placa;
    }

    @NonNull
    public String getCor() {
        return cor;
    }

    public void setCor(@NonNull String cor) {
        this.cor = cor;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getTipoCombustivel() {
        return tipoCombustivel;
    }

    public void setTipoCombustivel(int tipoCombustivel) {
        this.tipoCombustivel = tipoCombustivel;
    }

    public int getNumeroPortas() {
        return numeroPortas;
    }

    public void setNumeroPortas(int numeroPortas) {
        this.numeroPortas = numeroPortas;
    }

    public long getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(long quilometragem) {
        this.quilometragem = quilometragem;
    }

    public long getRenavan() {
        return renavan;
    }

    public void setRenavan(long renavan) {
        this.renavan = renavan;
    }

    @NonNull
    public String getChassi() {
        return chassi;
    }

    public void setChassi(@NonNull String chassi) {
        this.chassi = chassi;
    }

    public double getValorLocacao() {
        return valorLocacao;
    }

    public void setValorLocacao(double valorLocacao) {
        this.valorLocacao = valorLocacao;
    }

    public boolean iseDeParceiro() {
        return eDeParceiro;
    }

    public void seteDeParceiro(boolean eDeParceiro) {
        this.eDeParceiro = eDeParceiro;
    }

    public Automovel consultar(){
        return null;
    }

    public Automovel verificarKM(){
        return null;
    }
}
