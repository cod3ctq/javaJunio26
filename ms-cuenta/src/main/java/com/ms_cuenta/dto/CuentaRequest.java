package com.ms_cuenta.dto;

import jakarta.persistence.Column;

import java.time.LocalDate;

//Esta clase es un DTO, pensado para recibir los datos tal cual vienen desde el cliente
//reciber el nombre de peticin(request)
public class CuentaRequest {
    //Attributes
    private int cuentaId;
    private int clienteId;
    private int tipoCuentaId;
    private String numCuenta;
    private char clabe;
    private double saldo;
    private LocalDate fechaAP;
    private char status;

    public CuentaRequest(int cuentaId, int clienteId, int tipoCuentaId, String numCuenta, char clabe, double saldo, LocalDate fechaAP, char status) {
        this.cuentaId = cuentaId;
        this.clienteId = clienteId;
        this.tipoCuentaId = tipoCuentaId;
        this.numCuenta = numCuenta;
        this.clabe = clabe;
        this.saldo = saldo;
        this.fechaAP = fechaAP;
        this.status = status;
    }

    public CuentaRequest() {
    }

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

    public String getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(String numCuenta) {
        this.numCuenta = numCuenta;
    }

    public char getClabe() {
        return clabe;
    }

    public void setClabe(char clabe) {
        this.clabe = clabe;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public LocalDate getFechaAP() {
        return fechaAP;
    }

    public void setFechaAP(LocalDate fechaAP) {
        this.fechaAP = fechaAP;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }
}
