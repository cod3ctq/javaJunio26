package com.ddd_ms_prestamos.mapper;

import com.ddd_ms_persistence.entity.Cuenta;
import com.ddd_ms_persistence.entity.Prestamo;
import com.ddd_ms_persistence.entity.TipoPrestamo;
import com.ddd_ms_prestamos.dto.PrestamoResponse;
import com.ddd_ms_prestamos.util.PrestamoCalculator;

import java.time.LocalDate;

public class PrestamoMapper {

    public static PrestamoResponse toResponse(Cuenta cuenta, TipoPrestamo tipo, double monto, String status){
       PrestamoResponse response= null;
       boolean flag =(boolean)PrestamoCalculator.validarPrestamo(cuenta, tipo, monto).get(0);
       double cantidadAPrestar = (double)PrestamoCalculator.validarPrestamo(cuenta, tipo, monto).get(1);

        if (flag){
            response = new PrestamoResponse(tipo.getInteres(),monto,
                    cantidadAPrestar,(cantidadAPrestar/tipo.getPlazo()), tipo.getPlazo(),
                    LocalDate.now(),status);
        }
        return  response;
    }

    public static Prestamo toEntity(int clienteId, int tipoPrestamoId, double monto, int meses, double restante){

        Prestamo prestamo = new Prestamo();
        prestamo.setClienteId(clienteId);
        prestamo.setTipoId(tipoPrestamoId);
        prestamo.setMonto(monto);
        prestamo.setFecha(LocalDate.now());
        prestamo.setFechaFin(LocalDate.now().plusMonths(meses));
        prestamo.setRestante(restante);
        prestamo.setStatus('1');
        return prestamo;

    }


}
