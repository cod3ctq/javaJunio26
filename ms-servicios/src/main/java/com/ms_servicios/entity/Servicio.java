package com.ms_servicios.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;

//entidadad
//Replicar de manera exacta la estructura de una base de datos

@Entity
@Table(name = "SERVICIOS")
public class Servicio implements Serializable {

    @Id
    @Column(name="SERVICIO_ID", columnDefinition = "NUMBER")
    private int servicioID;

    @Column(name="CONVENIO", columnDefinition = "VARCHAR2(10)")
    private String convenio;

    @Column(name="DESCRIPCION", columnDefinition = "VARCHAR2(10)")
    private String descripcion;



    //Getter and setter
    public int getServicioID() {
        return servicioID;
    }

    public void setServicioID(int servicioID) {
        this.servicioID = servicioID;
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