package com.ms_prestamos.dto;


import java.time.LocalDate;

//Clase response  : clase pensada para exponer los datos de salida , que van del vaque
//hacia el cliente igual
//Este mapeo puedee ir cambiando segun los datos que necesitas exponer
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
