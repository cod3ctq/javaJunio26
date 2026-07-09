package com.ms_tipo_tarjeta.service;

import com.ms_tipo_tarjeta.dto.TipoTarjetaRequest;

import java.util.List;

public interface TipoTarjetaService<TipoTarjeta> {

    List mostrar ();
    TipoTarjeta guarder(TipoTarjetaRequest request);
    TipoTarjeta actualizar(TipoTarjetaRequest request);
    TipoTarjeta buscar(int id);
    TipoTarjeta eliminar(int id);


}
