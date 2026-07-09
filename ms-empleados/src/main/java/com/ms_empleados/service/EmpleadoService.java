package com.ms_empleados.service;

import com.ms_empleados.dto.EmpleadoRequest;
import com.ms_empleados.entity.Empleados;

import java.util.List;

public interface EmpleadoService {
    List mostrar ();
    Empleados guardar (EmpleadoRequest request);
    Empleados actualizar (EmpleadoRequest request);
    Empleados buscar (int id);
    String eliminar(int id);
}
