package com.ddd_ms_catalogos.service;

import com.ddd_ms_catalogos.dto.TipoPrestamoRequest;
import com.ddd_ms_catalogos.dto.TipoPrestamoResponse;

public interface TipoPrestamoService {

    TipoPrestamoResponse mostrar(TipoPrestamoRequest request);
    TipoPrestamoResponse buscar(TipoPrestamoResponse request);

}
