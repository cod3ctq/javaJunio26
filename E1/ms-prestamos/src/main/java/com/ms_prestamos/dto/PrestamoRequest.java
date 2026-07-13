package com.ms_prestamos.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.*;

import java.sql.Date;
import java.time.LocalDate;

//Request: es el  mapero de los datos como viene desde el cliente
//Este Mapeo puede ir cambiando segun sus necesidades delos flujos de backend
public class PrestamoRequest {


    private int prestamoId;

    public PrestamoRequest(int prestamoId, LocalDate fechaFin, Double monto, String rfc, Integer tipoId) {
        this.prestamoId = prestamoId;
        this.fechaFin = fechaFin;
        this.monto = monto;
        this.rfc = rfc;
        this.tipoId = tipoId;
    }

    @NotNull(message="tipoId es vacio")
    private Integer tipoId;

    @NotBlank(message = "el rfc no puede ser blanco")
    @Size(max= 13, min =13, message = "debe tener 13 caracteres")
    private String rfc;


    //ya no sera necesario incluirla en el request, dado que se roma del
    // sistema pivatie locadate
    @PastOrPresent(message = "Equipado pa la guerra puro personaje ")
    private LocalDate fecha;//se toma desde el sistema

    @NotNull(message = "Monto  no debe de ser nulo")
    @Positive(message = "NO es positivo")
    private Double monto;//Si se captura

    @NotNull(message = "Fecha Fin  no debe de ser nulo")
    @Future(message = "Fecha Fin debe de estar en el futuro")
    private LocalDate fechaFin;//depende de prestamo


    // Constructor vacio



    public PrestamoRequest() {
    }

    public int getPrestamoId() {
        return prestamoId;
    }

    public void setPrestamoId(int prestamoId) {
        this.prestamoId = prestamoId;
    }

    public int getTipoId() {
        return tipoId;
    }

    public void setTipoId(int tipoId) {
        this.tipoId = tipoId;
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

    public LocalDate getFecha() {
        return fecha;
    }

    public PrestamoRequest(int prestamoId, LocalDate fechaFin, Double monto, LocalDate fecha, String rfc, Integer tipoId) {
        this.prestamoId = prestamoId;
        this.fechaFin = fechaFin;
        this.monto = monto;
        this.fecha = fecha;
        this.rfc = rfc;
        this.tipoId = tipoId;
    }



    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
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
