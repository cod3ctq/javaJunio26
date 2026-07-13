package com.ms_cuenta.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

//entidad
//(1) Mapeo: Replicar de manera exacta la estructura de una tabla de db
@Entity
@Table(name = "CUENTAS")
public class Cuenta implements Serializable {

    //attributes
    @Id//id como en sql
    @GeneratedValue(strategy = GenerationType.IDENTITY)// generacion de Id de la mano con la db
    @Column(name = "CUENTA_ID",columnDefinition = "NUMBER")
    private int cuentaId;
    @Column(name = "CLIENTE_ID",columnDefinition = "NUMBER")
    private int clienteId;
    @Column(name = "TIPO_CUENTA_ID",columnDefinition = "NUMBER")
    private int tipoCuentaId;
    @Column(name = "NUM_CUENTA",columnDefinition = "VARCHAR2")
    private String numCuenta;
    @Column(name = "CLABE",columnDefinition = "CHAR")
    private char clabe;
    @Column(name = "SALDO",columnDefinition = "NUMBER")
    private double saldo;
    @Column(name = "FECHA_AP",columnDefinition = "DATE")
    private LocalDate fechaAP;
    @Column(name = "STATUS",columnDefinition = "CHAR")
    private char status;

    //getters and setters
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
