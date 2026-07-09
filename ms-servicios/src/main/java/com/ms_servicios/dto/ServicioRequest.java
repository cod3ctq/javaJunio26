package com.ms_servicios.dto;


//Esta clase es un DTO pensado para recibir los datos tal cual vienen desde el cliente
//Recibe el nombre de peticion (request)
public class ServicioRequest {

    private String convenio;
    private String descripcion;
    private int servicioId;

    public ServicioRequest(String convenio, String descripcion, int servicioId) {
        this.convenio = convenio;
        this.descripcion = descripcion;
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

    public int getServicioId() {
        return servicioId;
    }

    public void setServicioId(int servicioId) {
        this.servicioId = servicioId;
    }
}
