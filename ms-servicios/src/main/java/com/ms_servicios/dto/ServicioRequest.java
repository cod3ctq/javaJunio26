package com.ms_servicios.dto;

import jakarta.persistence.Column;

//Esta clase es un dto pensada para recibir los datos tal cual vienen del cliente
//Recibe el nombre de peticion (request)
public class ServicioRequest {

    private int servicioId;
    private String convenio;
    private String descripcion;

    //Genera constructor lleno, getter y seter

    public ServicioRequest(){}

    public ServicioRequest(int servicioId, String convenio, String descripcion) {
        this.servicioId = servicioId;
        this.convenio = convenio;
        this.descripcion = descripcion;
    }



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
