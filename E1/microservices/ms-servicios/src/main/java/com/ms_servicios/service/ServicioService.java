package com.ms_servicios.service;


import com.ms_servicios.dto.ServicioRequest;
import com.ms_servicios.entity.Servicio;

import java.util.List;

// Interface de negocio : Aquí se diseñan las operaciones especificas de las que este servicio
// se hará cargo
public interface ServicioService {

    List mostrar ();
    Servicio guardar(ServicioRequest request);
    Servicio actualizar(ServicioRequest request);
    Servicio buscar(int id);
    String eliminar (int id);

    // Diseñamos a traves de metodos abstractos las ideas de negocio que se atenderan en este servicio.


}
