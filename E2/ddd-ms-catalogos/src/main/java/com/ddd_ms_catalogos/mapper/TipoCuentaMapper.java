package com.ddd_ms_catalogos.mapper;

import com.ddd_ms_catalogos.dto.TipoCuentaResponse;
import com.ddd_ms_catalogos.dto.TipoPrestamoResponse;
import com.ddd_ms_persistence.entity.TipoCuenta;

public class TipoCuentaMapper {

    public static TipoCuentaResponse toResponse (TipoCuenta entity){
        return new TipoCuentaResponse(entity.getDescripcion(), entity.getSaldoMin(), entity.getSaldoMax());
    }
}
