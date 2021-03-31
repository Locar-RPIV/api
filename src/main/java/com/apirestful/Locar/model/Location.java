package com.apirestful.Locar.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "TB_LOCACAO")
public class Location {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_locacao")
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    @Column(unique = true, name = "placa")
    private String placa;

    @Column(name = "dataLocacao")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date dataLocacao;
    
    @Column(name = "dataDevolucao")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date dataDevolucao;
    
    @NonNull
    private double valorLocacao;
    
    @NonNull
    private double valorCaucao;
    
	@NonNull
    private double valorTotal;
    
    @NonNull
    private long quilometragemLocacao;
    
    @NonNull
    private long quilometragemDevolucao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Date getDataLocacao() {
        return dataLocacao;
    }

    public void setDataLocacao(Date dataLocacao) {
        this.dataLocacao = dataLocacao;
    }
    
    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }
    
    public long getQuilometragemLocacao() {
        return quilometragemLocacao;
    }

    public void setQuilometragemLocacao(long quilometragemLocacao) {
        this.quilometragemLocacao = quilometragemLocacao;
    }
    
    public long getQuilometragemDevolucao() {
        return quilometragemDevolucao;
    }

    public void setQuilometragemDevolucao(long quilometragemDevolucao) {
        this.quilometragemDevolucao = quilometragemDevolucao;
    }
    
    public double getValorLocacao() {
		return valorLocacao;
	}

	public void setValorLocacao(double valorLocacao) {
		this.valorLocacao = valorLocacao;
	}

	public double getValorCaucao() {
		return valorCaucao;
	}

	public void setValorCaucao(double valorCaucao) {
		this.valorCaucao = valorCaucao;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    
}
