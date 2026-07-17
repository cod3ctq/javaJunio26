package com.ddd_ms_persistence.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "TIPO_PRESTAMO")
public class TipoPrestamo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TIPO_PRESTAMO_ID")
    private int tipoPrestamoId;

    @Column(name = "DESCRIPCION")
    private String descripcion;

    @Column(name = "INTERES")
    private int interes;

    @Column(name = "PLAZO")
    private int plazo;

    public int getTipoPrestamoId() {
        return tipoPrestamoId;
    }

    public void setTipoPrestamoId(int tipoPrestamoId) {
        this.tipoPrestamoId = tipoPrestamoId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getInteres() {
        return interes;
    }

    public void setInteres(int interes) {
        this.interes = interes;
    }

    public int getPlazo() {
        return plazo;
    }

    public void setPlazo(int plazo) {
        this.plazo = plazo;
    }
}