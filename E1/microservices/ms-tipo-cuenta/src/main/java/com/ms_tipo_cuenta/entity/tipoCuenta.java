package com.ms_tipo_cuenta.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "TIPO_CUENTA")
public class tipoCuenta implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TIPO_CUENTA_ID", columnDefinition = "NUMBER" )
    private int tipoCuentaId;

    @Column(name = "DESCRIPCION", columnDefinition = "VARCHAR2(100)")
    private String descripcion;

    @Column(name = "SALDO_MIN", columnDefinition = "NUMBER(8,2)")
    private double saldoMin;

    @Column(name = "SALDO_MAX", columnDefinition = "NUMBER(8,2)")
    private double saldoMax;

    //Getter y Setter
    public int getTipoCuentaId() {
        return tipoCuentaId;
    }

    public void setTipoCuentaId(int tipoCuentaId) {
        this.tipoCuentaId = tipoCuentaId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getSaldoMin() {
        return saldoMin;
    }

    public void setSaldoMin(double saldoMin) {
        this.saldoMin = saldoMin;
    }

    public double getSaldoMax() {
        return saldoMax;
    }

    public void setSaldoMax(double saldoMax) {
        this.saldoMax = saldoMax;
    }
}
