package com.ms_cuenta.service;

import com.ms_cuenta.dto.CuentaRequest;
import com.ms_cuenta.entity.Cuenta;

import java.util.List;

//(4) interface de negocio: aqui se disenan las operaciones especificas de las que este servicio se hara cargo
// CRUD
public interface CuentaService {
    List mostrar();
    Cuenta guardar(CuentaRequest request);
    Cuenta actualizar(CuentaRequest request);
    Cuenta buscar(int id);
    String eliminar(int id);
}
