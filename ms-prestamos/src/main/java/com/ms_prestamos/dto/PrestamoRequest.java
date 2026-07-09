package com.ms_prestamos.dto;

import jakarta.persistence.Column;

import java.sql.Date;
import java.time.LocalDate;

public class PrestamoRequest {

    private int prestamoId;
    private int tipoId;
    private int clienteId;
    private LocalDate fecha;
    private double monto;
    private LocalDate fechaFin;
    private double restante;

    // Constructor vacio
    public PrestamoRequest() {
    }

    // Constructor lleno
    public PrestamoRequest(int prestamoId, int tipoId, int clienteId, LocalDate fecha, double monto, LocalDate fechaFin, double restante) {
        this.prestamoId = prestamoId;
        this.tipoId = tipoId;
        this.clienteId = clienteId;
        this.fecha = fecha;
        this.monto = monto;
        this.fechaFin = fechaFin;
        this.restante = restante;
    }

    // Getter y Setter
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

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
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

    public double getRestante() {
        return restante;
    }

    public void setRestante(double restante) {
        this.restante = restante;
    }
}
