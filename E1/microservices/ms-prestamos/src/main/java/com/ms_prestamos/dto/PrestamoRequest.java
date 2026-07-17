package com.ms_prestamos.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.*;

import java.sql.Date;
import java.time.LocalDate;


//Request  es el mapeo de los datos como vienen  desde el cliente
//Este mapeo puede ir cambiando segun las necesiddes de los flujos del baket
public class PrestamoRequest {

    private int prestamoId;

    @NotNull(message = "Este valor no puede quedar vacio")
    private Integer tipoId; //Pendiente se necesita otro servicio
    @NotBlank(message = "Este valor no puede quedarse vacio")
    @Size(max = 13, min = 13, message = "El rfc debe tener 13 caracteres")
    private String rfc;   //  pendiente rfc  nombre

  //YA No sera necesario iincluirla en el request dado que se toma de sistema
    //privata private LocalDate fecha;

    @NotNull(message = "Este valor no puede quedar vacio")
    @Positive(message = "Este vallor no puede ser menor a cero")
    private Double monto;  //Si se captura

    @NotNull(message = "Este valor puede quedar vacio")
    @Future(message = "La fecah fin debe de ser del futuro")
    private LocalDate fechaFin; //Depende del tipo de prestamo




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


    // Getter y Setter


    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
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





}
