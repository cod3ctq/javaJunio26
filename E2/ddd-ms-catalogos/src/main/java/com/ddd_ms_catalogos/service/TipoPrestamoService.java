package com.ddd_ms_catalogos.service;

import com.ddd_ms_catalogos.dto.TipoPrestamoResponse;

import java.util.List;

public interface TipoPrestamoService {

    List mostrar();
    TipoPrestamoResponse buscar(int id);


}
