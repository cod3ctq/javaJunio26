package com.ms_prestamos.mapper;

import com.ms_prestamos.dto.PrestamoRequest;
import com.ms_prestamos.dto.PrestamoResponse;
import com.ms_prestamos.entity.Prestamos;

import java.time.LocalDate;

//clase mapper: se encarga de convertir / transformar datos de un objeto a otro
public class PrestamoMapper {

    //Convierte un request en una entidad
    public static Prestamos requestToEntity(PrestamoRequest request, int clienteId){

        //creando un objeto para guardar los datos extraidos del request
        Prestamos p = new Prestamos();
        p.setTipoId(request.getTipoId());
        p.setClienteId(clienteId); // lo pasa al setter
        p.setFecha(LocalDate.now());
        p.setMonto(request.getMonto());
        p.setFechaFin(request.getFechaFin());
        p.setRestante(request.getMonto());
        p.setStatus('1'); // al momento de guardarlo, se marca como activo

        return p;

    }

    public static PrestamoResponse entityToResponse(Prestamos entity){
        return new PrestamoResponse(entity.getFecha(), entity.getMonto(),entity.getFechaFin());

    }

}
