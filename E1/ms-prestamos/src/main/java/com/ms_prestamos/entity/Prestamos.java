package com.ms_prestamos.entity;

// Entidad
// Mapeo: Replicar de manera exacta la estructura de una tabla de bd
// Paso 1 : mapear la entidad

import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;

@Entity
@Table(name="PRESTAMOS")
public class Prestamos implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="PRESTAMO_ID", columnDefinition = "NUMBER")
    private int prestamoId;

    @Column(name="TIPO_ID", columnDefinition = "NUMBER")
    private int tipoId;

    @Column(name="CLIENTE_ID", columnDefinition = "NUMBER")
    private int clienteId;

    @Column(name="FECHA", columnDefinition = "DATE")
    private LocalDate fecha;

    @Column(name="MONTO", columnDefinition = "NUMBER(8,2)")
    private double monto;

    @Column(name="FECHA_FIN", columnDefinition = "DATE")
    private LocalDate fechaFin;

    @Column(name="RESTANTE", columnDefinition = "NUMBER(8,2)")
    private double restante;

    @Column(name="STATUS", columnDefinition = "CHAR(1)")
    private char status;

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

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }
}
