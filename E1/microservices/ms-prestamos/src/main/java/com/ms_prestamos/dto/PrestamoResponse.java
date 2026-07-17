package com.ms_prestamos.dto;

import java.time.LocalDate;

// Clases Response : Clases pensadas para exponer los datos de salida, que van del backend hacia los clientes
// Este mapeo también puede ir cambiando según los datos que necesites exponer

public class PrestamoResponse {

    private LocalDate fecha;
    private double monto;
    private LocalDate fechaFin;

    public PrestamoResponse(LocalDate fecha, double monto, LocalDate fechaFin) {
        this.fecha = fecha;
        this.monto = monto;
        this.fechaFin = fechaFin;
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

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }
}
