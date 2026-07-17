package com.ms_servicios.dto;

import jakarta.persistence.Column;

//Esta clases es un DTO, pensado para recibir los datos tal cual vienen desde el cliente
//recibe el nombre de peticion (Request)
public class ServicioRequest {

    private  int servicioId;
    private String convenio;
    private String descripcion;

    public ServicioRequest(){}


    public ServicioRequest(int servicioId, String convenio, String descripcion) {
        this.servicioId = servicioId;
        this.convenio = convenio;
        this.descripcion = descripcion;
    }



    public String getConvenio() {
        return convenio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getServicioId() {
        return servicioId;
    }

    public void setConvenio(String convenio) {
        this.convenio = convenio;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setServicioId(int servicioId) {
        this.servicioId = servicioId;
    }
}
