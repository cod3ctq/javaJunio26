package com.ms_prestamos.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.*;

import java.sql.Date;
import java.time.LocalDate;

//request: Es el mapero de los datos como vienen desde el cielnte.Este mapero pude ir cambiando segun las necesidades de los flujos del backend
public class PrestamoRequest {

    //autoboxing
    private int prestamoId;
    @NotBlank(message = "Este valor no puede quedar vacio")
    private Integer tipoId;
    @NotBlank(message = "El rfc no puede quedar vacio o nulo")
    @Size(max = 13, min = 13, message = "El rfc debe tener 13 caracteres")
    private String rfc; //rfc, nombre

    //Ya no sera necesario incluirla en el request, dado que se toma de sistema
//    @PastOrPresent(message = "Fecha invalida. No puede ser del futuro")
//    private LocalDate fecha; //se toma desde sistema

    @NotBlank(message = "Este valor no puede quedar vacio")
    @Positive(message = "Este valor no puede ser menor a cero")
    private Double monto; // si se captura
    @NotBlank(message = "Este valor no puede quedar vacio")
    @Future(message = "Fecha del fin debe ser del futuro")
    private LocalDate fechaFin; //depende del tipo de prestamo

//    private double restante; // no se captura

    // Constructor vacio
    public PrestamoRequest() {
    }

    // Constructor lleno

    public PrestamoRequest(int prestamoId, Integer tipoId, String rfc, Double monto, LocalDate fechaFin) {
        this.prestamoId = prestamoId;
        this.tipoId = tipoId;
        this.rfc = rfc;
        this.monto = monto;
        this.fechaFin = fechaFin;
    }

    public int getPrestamoId() {
        return prestamoId;
    }

    public void setPrestamoId(int prestamoId) {
        this.prestamoId = prestamoId;
    }

    public Integer getTipoId() {
        return tipoId;
    }

    public void setTipoId(Integer tipoId) {
        this.tipoId = tipoId;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

}