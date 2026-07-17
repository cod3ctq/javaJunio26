package com.ms_abonos.dto;

import java.time.LocalDate;

public class AbonoRequest {
    private  int abonoId;
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

    public int getPrestamoId() {
        return prestamoId;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public double getMonto() {
        return monto;
    }

    public int getMedioPagoId() {
        return medioPagoId;
    }

    public void setAbonoId(int abonoId) {
        this.abonoId = abonoId;
    }

    public void setPrestamoId(int prestamoId) {
        this.prestamoId = prestamoId;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public void setMedioPagoId(int medioPagoId) {
        this.medioPagoId = medioPagoId;
    }
}
