package com.ms_servicios.service;


import com.ms_servicios.dto.ServicioRequest;
import com.ms_servicios.entity.Servicio;

import java.util.List;

//Interface de negocio: aqui se diseñan las operaciones espesificas de las que este servicio
//se hara cargo: Diseñamos a traves de metodos abstarctos las operaciones de negocios que se
//atenderan en este servicio
public interface ServicioService {
    List mostrar ();
    Servicio guardar(ServicioRequest request);
    Servicio actualizar(ServicioRequest request);
    Servicio buscar(int id);
    String eliminar(int id);











}
