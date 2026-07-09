package com.ms_servicios.entity;

import jakarta.persistence.*;

import java.io.Serializable;
//paso 1: mapear la entidad
//paso 2:
//paso 2:

//Entidad

//MAPEO: Replicar de manera exacta la estructura de una tabla de BD
@Entity
@Table(name="SERVICIOS")
public class Servicio implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="SERVICIOS", columnDefinition = "NUMBER")
    private int servicioId;

    @Column(name="CONVENIO", columnDefinition = "VARCHAR(10)")
    private String convenio;

    @Column(name="DESCRIPCION", columnDefinition = "VARCHAR(10)")
    private String descripcion;

    public int getServicioId() {
        return servicioId;
    }

    public void setServicioId(int servicioId) {
        this.servicioId = servicioId;
    }

    public String getConvenio() {
        return convenio;
    }

    public void setConvenio(String convenio) {
        this.convenio = convenio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
