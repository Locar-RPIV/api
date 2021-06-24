package com.apirestful.Locar.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Motorcycle
 */
@Entity
public class Motorcycle extends Automovel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_veiculo")
    private int id;
    
    @Column(name = "potencia")
    private String potencia;

    @Column(name = "tipoCombustivel")
    private int tipoCombustivel;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPotencia() {
        return potencia;
    }

    public void setPotencia(String potencia) {
        this.potencia = potencia;
    }

    public int getTipoCombustivel() {
        return tipoCombustivel;
    }

    public void setTipoCombustivel(int tipoCombustivel) {
        this.tipoCombustivel = tipoCombustivel;
    }

    public String getCapacidadePortaMalas() {
        return capacidadePortaMalas;
    }

    public void setCapacidadePortaMalas(String capacidadePortaMalas) {
        this.capacidadePortaMalas = capacidadePortaMalas;
    }

    @Column(name = "capacidadePortaMalas")
    private String capacidadePortaMalas;


}