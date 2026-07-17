package com.ddd_ms_persistence.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "CUENTAS")
public class Cuenta {

    @Id
    @Column(name = "CUENTA_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cuentaId;

    @Column(name = "CLIENTE_ID")
    private int clienteId;

    @Column(name = "TIPO_CUENTA_ID")
    private int tipoCuentaId;

    @Column(name = "NUM_CUENTA")
    private String numeroCuenta;

    @Column(name = "CLABE")
    private String clabe;

    @Column(name = "SALDO")
    private double saldo;

    @Column(name = "FECHA_AP")
    private LocalDate fechaApertura;

    @Column(name = "STATUS")
    private String status;

    public int getCuentaId() {
        return cuentaId;
    }

    public void setCuentaId(int cuentaId) {
        this.cuentaId = cuentaId;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public int getTipoCuentaId() {
        return tipoCuentaId;
    }

    public void setTipoCuentaId(int tipoCuentaId) {
        this.tipoCuentaId = tipoCuentaId;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getClabe() {
        return clabe;
    }

    public void setClabe(String clabe) {
        this.clabe = clabe;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public LocalDate getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(LocalDate fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}