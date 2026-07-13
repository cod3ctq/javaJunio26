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
    @NotNull(message = "Este valor no puede quedarse vacio")
    private Integer clienteId;   //  pendiente rfc  nombre
    @PastOrPresent(message = "Fecha invalida. No puede ser del futuro")
    private LocalDate fecha; //Se tomaa desde sistema

    @NotNull(message = "Este valor no puede quedar vacio")
    @Positive(message = "Este vallor no puede ser menor a cero")
    private Double monto;  //Si se captura

    @NotNull(message = "Este valor puede quedar vacio")
    @Future(message = "La fecah fin debe de ser del futuro")
    private LocalDate fechaFin; //Depende del tipo de prestamo

    private Double restante; //no se captura


    // Constructor vacio
    public PrestamoRequest() {
    }

    // Constructor lleno


    public PrestamoRequest(Integer clienteId, LocalDate fecha, LocalDate fechaFin, Double monto, int prestamoId, Double restante, Integer tipoId) {
        this.clienteId = clienteId;
        this.fecha = fecha;
        this.fechaFin = fechaFin;
        this.monto = monto;
        this.prestamoId = prestamoId;
        this.restante = restante;
        this.tipoId = tipoId;
    }

    // Getter y Setter


    public Integer getClienteId() {
        return clienteId;
    }

    public void setClienteId(Integer clienteId) {
        this.clienteId = clienteId;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
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

    public Double getRestante() {
        return restante;
    }

    public void setRestante(Double restante) {
        this.restante = restante;
    }

    public Integer getTipoId() {
        return tipoId;
    }

    public void setTipoId(Integer tipoId) {
        this.tipoId = tipoId;
    }
}
