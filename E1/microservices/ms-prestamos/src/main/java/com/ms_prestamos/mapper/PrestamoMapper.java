package com.ms_prestamos.mapper;

import com.ms_prestamos.dto.PrestamoRequest;
import com.ms_prestamos.dto.PrestamosResponse;
import com.ms_prestamos.entity.Prestamos;

import java.time.LocalDate;

public class PrestamoMapper {

    public static Prestamos requestToEntity(PrestamoRequest request, int clienteId){
        Prestamos p =new Prestamos();
        p.setTipoId(request.getTipoId());
        p.setClienteId(clienteId);
        p.setFecha(LocalDate.now());
        p.setMonto(request.getMonto());
        p.setFechaFin(request.getFechaFin());
        p.setRestante(request.getMonto());
        p.setStatus('1');//Al momento de guardarlo activo
        return p;

    }

    public static PrestamosResponse entityToResponse(Prestamos entity){
        return new PrestamosResponse(entity.getFecha(),entity.getMonto(),entity.getFechaFin());
    }
}
