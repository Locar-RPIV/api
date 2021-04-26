package com.apirestful.Locar.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "TB_LOCACAO")
public class Location {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_locacao")
    private int id;

    @OneToOne
    @JoinColumn(name = "id_reserva")
    private Reservation reserva;

    @Column(name = "dataLocacao")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date dataLocacao;
    
    @Column(name = "dataDevolucao")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date dataDevolucao;
  
    @Column(name = "valorLocacao")
    private double valorLocacao;
    
    @Column(name = "valorCaucao")
    private double valorCaucao;
    
	@Column(name = "valorTotal")
    private double valorTotal;
    
    @Column(name = "quilometragemLocacao")
    private long quilometragemLocacao;
    
    @Column(name = "quilometragemDevolucao")
    private long quilometragemDevolucao;
    
    @Column(name = "duracao")
    private float duracao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Reservation getReserva() {
        return reserva;
    }

    public void setReserva(Reservation reserva) {
        this.reserva = reserva;
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
    
    public float getDuracao() {
        return duracao;
    }

    public void setDuracao(float duracao) {
        this.duracao = duracao;
    }
    
}
