package com.ms_prestamos.dto;

import java.time.LocalDate;

//Clases Response: Clases pensados para exponer los datos de salida, que van del backend
//hacia el cliente
//este mapeo tambien puede ir cambiando segun los datos que necesites obtener
public class PrestamoResponse {
    //Attributes
    private LocalDate fechDate;
    private double monto;
    private LocalDate fechaFin;

    public PrestamoResponse(LocalDate fechDate, double monto, LocalDate fechaFin) {
        this.fechDate = fechDate;
        this.monto = monto;
        this.fechaFin = fechaFin;
    }

    public PrestamoResponse() {
    }

    public LocalDate getFechDate() {
        return fechDate;
    }

    public void setFechDate(LocalDate fechDate) {
        this.fechDate = fechDate;
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
