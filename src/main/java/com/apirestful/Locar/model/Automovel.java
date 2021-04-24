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

    @NonNull
    @Column(name = "marca")
    private String marca;

    @NonNull
    @Column(name = "modelo")
    private String modelo;
    
    @NonNull
    @Column(name = "status")
    private String status;

    @NonNull
    @Column(name = "potencia")
    private String potencia;

    @NonNull
    @Column(name = "placa")
    private String placa;

    @NonNull
    @Column(name = "cor")
    private String cor;

    @NonNull
    @Column(name = "ano")
    private int ano;

    @NonNull
    @Column(name = "tipoCombustivel")
    private int tipoCombustivel;

    @NonNull
    @Column(name = "numeroPortas")
    private int numeroPortas;

    @NonNull
    @Column(name = "quilometragem")
    private long quilometragem;

    @NonNull
    @Column(name = "renavam")
    private long renavam;

    @NonNull
    @Column(name = "chassi")
    private String chassi;

    @NonNull
    @Column(name = "valorLocacao")
    private double valorLocacao;

    @NonNull
    @Column(name = "carroParceiro")
    private boolean carroParceiro;

    @Column(name = "cpfParceiro")
    private long cpfParceiro;

    @NonNull
    @Column(name = "filial")
    private int filial;

    @NonNull
    @Column(name = "imageUrl")
    private byte[] imageUrl;

    @Column(name = "capacidadePortaMalas")
    private String capacidadePortaMalas;

    @Column(name = "tipoVeiculo")
    private String tipoVeiculo;

    @Column(name = "numeroAssentos")
    private int numeroAssentos;

    public long getCpfParceiro() {
        return cpfParceiro;
    }
    
    public void setCpfParceiro(long cpfParceiro) {
        this.cpfParceiro = cpfParceiro;
    }

    public byte[] getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(byte[] imageUrl) {
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

    @NonNull
    public String getStatus() {
        return status;
    }

    public void setStatus(@NonNull String status) {
        this.status = status;
    }

    public String getPotencia() {
        return potencia;
    }

    public void setPotencia(String potencia) {
        this.potencia = potencia;
    }

    public int getNumeroAssentos() {
        return numeroAssentos;
    }

    public void setNumeroAssentos(int numeroAssentos) {
        this.numeroAssentos = numeroAssentos;
    }

    public String getCapacidadePortaMalas() {
        return capacidadePortaMalas;
    }

    public void setCapacidadePortaMalas(String capacidadePortaMalas) {
        this.capacidadePortaMalas = capacidadePortaMalas;
    }

    public String getTipoVeiculo() {
        return tipoVeiculo;
    }

    public void setTipoVeiculo(String tipoVeiculo) {
        this.tipoVeiculo = tipoVeiculo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
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

    public long getRenavam() {
        return renavam;
    }

    public void setRenavam(long renavam) {
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

    public Automovel consultar(){
        return null;
    }

    public Automovel verificarKM(){
        return null;
    }

}
