package com.ms_servicios.dto;

//Esta clase es un DTO, pensado para recibir los datos tal cual vienen desde el cliente
//reciber el nombre de peticin(request)
public class ServicioRequest {
    private int servicioId;
    private String convenio;
    private String description;

    public ServicioRequest(int servicioId, String convenio, String description) {
        this.servicioId = servicioId;
        this.convenio = convenio;
        this.description = description;
    }

    public ServicioRequest() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
