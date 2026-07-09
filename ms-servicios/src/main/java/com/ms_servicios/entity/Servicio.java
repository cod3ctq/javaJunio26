package com.ms_servicios.entity;

import jakarta.persistence.*;

import java.io.Serializable;

//entidad
//Mapeo: Replicar de manera exacta la estructura de una tabla de db
@Entity
@Table(name = "SERVICIOS")
public class Servicio implements Serializable {

    //attributes
    @Id // id como en sql
    @GeneratedValue(strategy = GenerationType.IDENTITY) // es como el codigo
    @Column(name="SERVICIO_ID",columnDefinition = "NUMBER")
    private int servicioId;
    @Column(name = "CONVENIO", columnDefinition = "VARCHAR2(20)")
    private String convenio;
    @Column(name = "DESCRIPCION", columnDefinition = "VARCHAR2(30)")
    private String description;

    //getters and setters
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
