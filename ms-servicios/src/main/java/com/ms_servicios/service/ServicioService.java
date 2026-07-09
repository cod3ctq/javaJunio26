package com.ms_servicios.service;

import com.ms_servicios.dto.ServicioRequest;
import com.ms_servicios.entity.Servicio;

import java.util.List;

//Interface de negocio: Aqui se diseñan las operaciones especificas de las que este servicio
//se haga cargo: Diseñamos por metodos abstractos las operaciones de negocio que se atenderan en este servicio(Paso 4)
public interface ServicioService {
    List mostrar();
    Servicio guardar (ServicioRequest request);
    Servicio actualizar (ServicioRequest request);
    Servicio buscar (int id);
    String eliminar (int id);
}
