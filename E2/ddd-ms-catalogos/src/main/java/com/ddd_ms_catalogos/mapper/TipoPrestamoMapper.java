package com.ddd_ms_catalogos.mapper;

import com.ddd_ms_catalogos.dto.TipoPrestamoResponse;
import com.ddd_ms_persistence.entity.TipoPrestamo;

public class TipoPrestamoMapper {

    public static TipoPrestamoResponse toResponse(TipoPrestamo entity){
        return new TipoPrestamoResponse(entity.getDescripcion(), entity.getInteres(), entity.getPlazo());

    }
}
