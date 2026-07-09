package com.ms_servicios.dto;

import jakarta.persistence.Column;
//esta clase es un DTO pensando  par resibir los datos tal cual desde el cliente
//recibe el nombre de ppeticion (request)
public class ServicioRequest {
private int servicioId;
    private String convenio;
    private String descripcion;
public ServicioRequest(){

}

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
