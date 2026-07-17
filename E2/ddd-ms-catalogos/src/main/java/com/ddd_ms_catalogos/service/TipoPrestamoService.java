package com.ddd_ms_catalogos.service;

import com.ddd_ms_catalogos.dto.TipoPrestamoResponse;
import com.ddd_ms_persistence.entity.TipoPrestamo;

import java.util.List;

public interface TipoPrestamoService {
    List<TipoPrestamo> mostrar();
    TipoPrestamoResponse buscar (int id);





}
