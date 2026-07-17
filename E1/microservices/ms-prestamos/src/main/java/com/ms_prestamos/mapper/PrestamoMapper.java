package com.ms_prestamos.mapper;

import com.ms_prestamos.dto.PrestamoRequest;
import com.ms_prestamos.dto.PrestamoResponse;
import com.ms_prestamos.entity.Prestamos;

import java.time.LocalDate;

//se encarga de convertir/datos de un objeto a otro
public class PrestamoMapper {

    public static Prestamos requestToEntity(PrestamoRequest request, int clienteId) {
        Prestamos p = new Prestamos();
        p.setTipoId(request.getTipoId());
        p.setClienteId(clienteId);
        p.setFecha(LocalDate.now());
        p.setMonto(request.getMonto());
        p.setFechaFin(request.getFechaFin());
        p.setRestante(request.getMonto());
        p.setStatus('1'); // se crea con el valor por default 1 que simboliza que esta activo
        return p;
    }

    public static PrestamoResponse entityToResponse(Prestamos entity){
        return new PrestamoResponse(entity.getFecha(),entity.getMonto(), entity.getFechaFin());
    }


}
