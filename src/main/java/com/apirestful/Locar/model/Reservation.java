package com.apirestful.Locar.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "TB_RESERVAS")
public class Reservation {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reserva")
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    @OneToOne
    @JoinColumn(name = "id_veiculo")
    private Automovel veiculo;

    @Column(name = "status")
    private String status;

    @Column(name = "dataRetirada")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date dataRetirada;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Automovel getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Automovel veiculo) {
        this.veiculo = veiculo;
    }

    public Date getDataRetirada() {
        return dataRetirada;
    }

    public void setDataRetirada(Date dataRetirada) {
        this.dataRetirada = dataRetirada;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    
}
