package com.ms_servicios.entity;

import jakarta.persistence.*;

import java.io.Serializable;

//Entidad
//Mapeo : Replicar de manera exacta la estructura de una tabla de bd
// Paso 1 : mapear la entidad
@Entity
@Table(name = "SERVICIOS")
public class Servicio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SERVICIO_ID", columnDefinition = "NUMBER")
    private int servicioId;

    @Column(name = "CONVENIO", columnDefinition = "VARCHAR2(10)")
    private String convenio;

    @Column(name = "DESCRIPCION", columnDefinition = "VARCHAR2(30)")
    private String descripcion;


    //Getter y Setter
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
