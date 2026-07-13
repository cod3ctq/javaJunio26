package com.ms_abonos.dto;

import jakarta.persistence.Column;

import java.time.LocalDate;

public class AbonoRequest {

    private int abonoId;
    private int prestamoId;
    private LocalDate fecha;
    private double monto;
    private int medioPagoId;

    public AbonoRequest(){}

    public AbonoRequest(int abonoId, int prestamoId, LocalDate fecha, double monto, int medioPagoId) {
        this.abonoId = abonoId;
        this.prestamoId = prestamoId;
        this.fecha = fecha;
        this.monto = monto;
        this.medioPagoId = medioPagoId;
    }

    public int getAbonoId() {
        return abonoId;
    }

    public void setAbonoId(int abonoId) {
        this.abonoId = abonoId;
    }

    public int getPrestamoId() {
        return prestamoId;
    }

    public void setPrestamoId(int prestamoId) {
        this.prestamoId = prestamoId;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public int getMedioPagoId() {
        return medioPagoId;
    }

    public void setMedioPagoId(int medioPagoId) {
        this.medioPagoId = medioPagoId;
    }

    @Override
    public String toString() {
        return "AbonoRequest{" +
                "abonoId=" + abonoId +
                ", prestamoId=" + prestamoId +
                ", fecha=" + fecha +
                ", monto=" + monto +
                ", medioPagoId=" + medioPagoId +
                '}';
    }
}
