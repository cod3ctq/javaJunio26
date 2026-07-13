package com.ms_prestamos.mapper;

import com.ms_prestamos.dto.PrestamoRequest;
import com.ms_prestamos.dto.PrestamoResponse;
import com.ms_prestamos.entity.Prestamos;

import java.time.LocalDate;

//Se encarga

public class PrestamoMapper {

    // Convierte un request en una entidad
    public static Prestamos requestToEntity(PrestamoRequest request, int clienteId){

        Prestamos p = new Prestamos();
        p.setTipoId(request.getTipoId());
        p.setClienteId(clienteId);
        p.setFecha(LocalDate.now());
        p.setMonto(request.getMonto());
        p.setFechaFin(request.getFechaFin());
        p.setRestante(request.getMonto());
        p.setStatus('1'); //Al momento de guardarla dse marca como activa
        return p;
    }


    // Convierte una entidad en un response
    public static PrestamoResponse entityToResponse(Prestamos entity){
        return new PrestamoResponse(entity.getFecha(), entity.getMonto(), entity.getFechaFin());
    }




}
