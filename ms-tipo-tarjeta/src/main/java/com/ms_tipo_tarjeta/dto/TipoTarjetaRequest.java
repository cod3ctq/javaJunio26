package com.ms_tipo_tarjeta.dto;


// Esta clase es un dto pensado para recibir los datos tal cual vienen del cliente
//Recibe el nombre de peticion (request)
public class TipoTarjetaRequest {

    private  int tipoTId;
    private String descripcion;

    //Generar constructor lleno, getters y setters
    public  TipoTarjetaRequest(){}


    public TipoTarjetaRequest(int tipoTId, String descripcion) {
        this.tipoTId = tipoTId;
        this.descripcion = descripcion;
    }


    public int getTipoTId() {
        return tipoTId;
    }

    public void setTipoTId(int tipoTId) {
        this.tipoTId = tipoTId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
