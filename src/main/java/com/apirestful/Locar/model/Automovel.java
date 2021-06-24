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
    @Column(name = "id_veiculo")
    private int id;

    @Column(name = "marca")
    private String marca;

    @Column(name = "modelo")
    private String modelo;

    @Column(name = "placa")
    private String placa;
 
    @Column(name = "status")
    private String status;

    @Column(name = "cor")
    private String cor;

    @Column(name = "ano")
    private int ano;

    @Column(name = "quilometragem")
    private long quilometragem;

    @Column(name = "renavam")
    private String renavam;

    @Column(name = "chassi")
    private String chassi;

    @Column(name = "valorLocacao")
    private double valorLocacao;

    @Column(name = "carroParceiro")
    private boolean carroParceiro;

    @Column(name = "cpfParceiro")
    private String cpfParceiro;

    @Column(name = "filial")
    private int filial;

    @Column(name = "numeroAssentos")
    private int numeroAssentos;

    @Column(name = "aro")
    private String aro;

    @Column(name = "marcha")
    private String marcha;

    @Column(name = "amortecedor")
    private String amortecedor;

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getAmortecedor() {
        return amortecedor;
    }

    public void setAmortecedor(String amortecedor) {
        this.amortecedor = amortecedor;
    }

    public String getAro() {
        return aro;
    }

    public void setAro(String aro) {
        this.aro = aro;
    }

    public String getMarcha() {
        return marcha;
    }

    public void setMarcha(String marcha) {
        this.marcha = marcha;
    }

    public String getCpfParceiro() {
        return cpfParceiro;
    }

    public void setCpfParceiro(String cpfParceiro) {
        this.cpfParceiro = cpfParceiro;
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

    @NonNull
    public String getStatus() {
        return status;
    }

    public void setStatus(@NonNull String status) {
        this.status = status;
    }

    public int getNumeroAssentos() {
        return numeroAssentos;
    }

    public void setNumeroAssentos(int numeroAssentos) {
        this.numeroAssentos = numeroAssentos;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public long getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(long quilometragem) {
        this.quilometragem = quilometragem;
    }

    public String getRenavam() {
        return renavam;
    }

    public void setRenavam(String renavam) {
        this.renavam = renavam;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
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

}
