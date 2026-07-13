package com.ms_servicios.service;


import com.ms_servicios.dto.ServicioRequest;

import java.util.List;

// Interface de negocio: aqui se diseñan las operaciones especificas de las que este servicio
// se hara cargo
public interface ServiciosService<Servcio> {
    List mostrar ();
    Servcio guardar(ServicioRequest request);
    Servcio actualizar(ServicioRequest request);
    Servcio buscar(int id);
    Servcio eliminar(int id);







}
