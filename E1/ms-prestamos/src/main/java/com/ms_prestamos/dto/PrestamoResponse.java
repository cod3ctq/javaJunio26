package com.ms_prestamos.dto;

import java.time.LocalDate;

public class PrestamoResponse {
    private LocalDate fecha;
    private Double monto;
    private LocalDate fecha_fin;


    public PrestamoResponse(LocalDate fecha, Double monto, LocalDate fecha_fin) {
        this.fecha = fecha;
        this.monto = monto;
        this.fecha_fin = fecha_fin;
    }

    public PrestamoResponse() {


    }

    public LocalDate getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(LocalDate fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}
