package com.apirestful.Locar.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import org.springframework.lang.NonNull;

@Entity
@Table(name = "TB_PAYMENT")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @NonNull
    private String partnerRG;
    
    @NonNull
    private double paymentValue;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date date;

    public Payment(String partnerRG, double paymentValue, Date date) {
        this.partnerRG = partnerRG;
        this.paymentValue = paymentValue;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPartnerRG() {
        return partnerRG;
    }

    public void setPartnerRG(String partnerRG) {
        this.partnerRG = partnerRG;
    }

    public double getPaymentValue() {
        return this.paymentValue;
    }

    public void setPaymentValue(double paymentValue) {
        this.paymentValue = paymentValue;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
