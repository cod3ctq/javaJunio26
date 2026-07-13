package com.ms_prestamos.mapper;

import com.ms_prestamos.dto.PrestamoRequest;
import com.ms_prestamos.dto.PrestamoResponse;
import com.ms_prestamos.entity.Prestamos;

//Se encarga

public class PrestamoMapper {

    // Convierte un request en una entidad
    public static Prestamos requestToEntity(PrestamoRequest request){

        Prestamos p = new Prestamos();
        p.setTipoId(request.getTipoId());
        p.setClienteId(request.getClienteId());
        p.setFecha(request.getFecha());
        p.setMonto(request.getMonto());
        p.setFechaFin(request.getFechaFin());
        p.setRestante(request.getRestante());

        return p;
    }


    // Convierte una entidad en un response
    public static PrestamoResponse entityToResponse(Prestamos entity){
        return new PrestamoResponse(entity.getFecha(), entity.getMonto(), entity.getFechaFin());
    }




}
