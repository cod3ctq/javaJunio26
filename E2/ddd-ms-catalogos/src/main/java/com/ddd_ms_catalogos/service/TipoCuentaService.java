package com.ddd_ms_catalogos.service;

import com.ddd_ms_catalogos.dto.TipoCuentaResponse;

import java.util.List;

public interface TipoCuentaService {

    List mostrar();
    TipoCuentaResponse buscar(int id);
}
