package com.ddd_ms_cuentas.service;

import com.ddd_ms_cuentas.dto.CuentaRequest;
import com.ddd_ms_cuentas.dto.CuentaResponse;

public interface CuentasService {

    // Diseño de los casos de uso (operaciones de negocio)

    // Validar si la cuenta de un cliente está activa  GET /cuentas/{numero}/status
    // Consultar saldo disponible GET /cuentas/{numero}/saldo

    CuentaResponse validarCuenta(CuentaRequest request);
    CuentaResponse consultarSaldo(CuentaRequest request);


}
