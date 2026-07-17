package com.ddd_ms_persistence.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "MEDIOS_PAGO")
public class MedioPago implements Serializable {

    @Id
    @Column(name = "MEDIO_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int medioId;

    @Column(name = "DESCRIPCION")
    private String descripcion;

    public int getMedioId() {
        return medioId;
    }

    public void setMedioId(int medioId) {
        this.medioId = medioId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}