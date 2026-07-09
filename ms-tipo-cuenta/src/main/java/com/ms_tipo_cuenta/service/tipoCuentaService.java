package com.ms_tipo_cuenta.service;
import com.ms_tipo_cuenta.dto.tipoCuentaRequest;
import com.ms_tipo_cuenta.entity.tipoCuenta;

import java.util.List;

public interface tipoCuentaService {
    List mostrar();
    tipoCuenta guardar(tipoCuentaRequest request);
    tipoCuenta actualizar(tipoCuentaRequest request);
    tipoCuenta buscar (int id);
    String eliminar (int id);
}
