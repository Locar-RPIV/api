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
    private String marca;

    @NonNull
    private String modelo;

    @NonNull
    private int potencia;

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
    private boolean carroParceiro;

    @NonNull
    private int filial;

    @NonNull
    private String imageUrl;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getFilial() {
        return filial;
    }

    public void setFilial(int filial) {
        this.filial = filial;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public String getMarca() {
        return marca;
    }

    public void setMarca(@NonNull String marca) {
        this.marca = marca;
    }

    @NonNull
    public String getModelo() {
        return modelo;
    }

    public void setModelo(@NonNull String modelo) {
        this.modelo = modelo;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
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

    public boolean getCarroParceiro() {
        return carroParceiro;
    }

    public void setCarroParceiro(boolean carroParceiro) {
        this.carroParceiro = carroParceiro;
    }

    public Automovel consultar(){
        return null;
    }

    public Automovel verificarKM(){
        return null;
    }

    /*public Automovel(int id, @NonNull String marca, @NonNull String modelo, int potencia, @NonNull String placa, @NonNull String cor, int ano, int tipoCombustivel, int numeroPortas, long quilometragem, long renavan, @NonNull String chassi, double valorLocacao, boolean eDeParceiro) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.potencia = potencia;
        this.placa = placa;
        this.cor = cor;
        this.ano = ano;
        this.tipoCombustivel = tipoCombustivel;
        this.numeroPortas = numeroPortas;
        this.quilometragem = quilometragem;
        this.renavan = renavan;
        this.chassi = chassi;
        this.valorLocacao = valorLocacao;
        this.eDeParceiro = eDeParceiro;
    }
    */
}
