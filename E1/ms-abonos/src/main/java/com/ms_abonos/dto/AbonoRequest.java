package com.ms_abonos.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

public class AbonoRequest {



    private int abonoId;
    private int prestamoId;
    private LocalDate fecha;
    private double monto;
    private int medioPagoId;


    public  AbonoRequest(){}

    public AbonoRequest(int abonoId, LocalDate fecha, int medioPagoId, double monto, int prestamoId) {
        this.abonoId = abonoId;
        this.fecha = fecha;
        this.medioPagoId = medioPagoId;
        this.monto = monto;
        this.prestamoId = prestamoId;
    }


    public int getAbonoId() {
        return abonoId;
    }

    public void setAbonoId(int abonoId) {
        this.abonoId = abonoId;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getMedioPagoId() {
        return medioPagoId;
    }

    public void setMedioPagoId(int medioPagoId) {
        this.medioPagoId = medioPagoId;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public int getPrestamoId() {
        return prestamoId;
    }

    public void setPrestamoId(int prestamoId) {
        this.prestamoId = prestamoId;
    }
}
