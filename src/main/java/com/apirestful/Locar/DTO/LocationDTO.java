package com.apirestful.Locar.DTO;

import java.util.Date;

import com.apirestful.Locar.model.User;
import com.fasterxml.jackson.annotation.JsonFormat;

import org.springframework.beans.factory.annotation.Autowired;

public class LocationDTO {

    @Autowired
    private User user;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date dataLocacao;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date dataDevolucao;

    private String placa;

    private double valorLocacao;

    private double valorCaucao;

    private double valorTotal;
    
    private long quilometragemLocacao;
    
    private long quilometragemDevolucao;

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
    
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
}
