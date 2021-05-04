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
 
    @Column(name = "status")
    private String status;

    @Column(name = "potencia")
    private String potencia;

    @Column(name = "placa")
    private String placa;

    @Column(name = "cor")
    private String cor;

    @Column(name = "ano")
    private int ano;

    @Column(name = "tipoCombustivel")
    private int tipoCombustivel;

    @Column(name = "numeroPortas")
    private int numeroPortas;

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

    @Column(name = "imageUrl")
    private byte[] imageUrl;

    @Column(name = "capacidadePortaMalas")
    private String capacidadePortaMalas;

    @Column(name = "tipoVeiculo")
    private String tipoVeiculo;

    @Column(name = "numeroAssentos")
    private int numeroAssentos;

    @Column(name = "aro")
    private String aro;

    @Column(name = "marcha")
    private String marcha;

    @Column(name = "amortecedor")
    private String amortecedor;

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

    public Automovel consultar(){
        return null;
    }

    public Automovel verificarKM(){
        return null;
    }

}
