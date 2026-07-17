package com.ddd_ms_catalogos.mapper;

import com.ddd_ms_catalogos.dto.TipoPrestamoResponse;
import com.ddd_ms_persistence.entity.TipoPrestamo;
import com.ddd_ms_persistence.repository.PrestamoRepository;

public class TipoPrestamoMapper {
    public static TipoPrestamoResponse toResponse(TipoPrestamo tipoPrestamo){
        return new TipoPrestamoResponse(tipoPrestamo.getTipoPrestamoId(),
                tipoPrestamo.getDescripcion(), tipoPrestamo.getInteres(), tipoPrestamo.getInteres());
    }
}
