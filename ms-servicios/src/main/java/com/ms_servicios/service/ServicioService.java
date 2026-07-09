package com.ms_servicios.service;

import com.ms_servicios.dto.ServicioRequest;
import com.ms_servicios.entity.Servicio;

import java.util.List;

//(4) interface de negocio: aqui se disenan las operaciones especificas de las que este servicio se hara cargo
// CRUD
public interface ServicioService {
    List mostrar();
    Servicio guardar(ServicioRequest request);
    Servicio actualizar(ServicioRequest request);
    Servicio buscar(int id);
    String eliminar(int id);

}
