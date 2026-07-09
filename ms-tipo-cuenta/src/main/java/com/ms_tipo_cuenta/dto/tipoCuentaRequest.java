package com.ms_tipo_cuenta.dto;
import jakarta.persistence.Column;
public class tipoCuentaRequest {

    private int tipoCuentaId;
    private String descripcion;
    private double saldoMinimo;
    private double saldoMaximo;

    public tipoCuentaRequest() {
    }

    public tipoCuentaRequest(int tipoCuentaId, String descripcion, double saldoMinimo, double saldoMaximo) {
        this.tipoCuentaId = tipoCuentaId;
        this.descripcion = descripcion;
        this.saldoMinimo = saldoMinimo;
        this.saldoMaximo = saldoMaximo;
    }

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

    public double getSaldoMinimo() {
        return saldoMinimo;
    }

    public void setSaldoMinimo(double saldoMinimo) {
        this.saldoMinimo = saldoMinimo;
    }

    public double getSaldoMaximo() {
        return saldoMaximo;
    }

    public void setSaldoMaximo(double saldoMaximo) {
        this.saldoMaximo = saldoMaximo;
    }
}
