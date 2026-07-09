package com.ms_tarjeta.service;


import com.ms_tarjeta.dto.TarjetaRequest;

import java.util.List;

public interface TarjetaService<Tarjeta>{
List   mostrar ();
    Tarjeta guardar(TarjetaRequest request);
    Tarjeta actualizar(TarjetaRequest request);
    Tarjeta buscar(int id);
    Tarjeta eliminar(int id);


}
