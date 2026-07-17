package com.ddd_ms_prestamos.service;

import com.ddd_ms_prestamos.dto.PrestamoRequest;
import com.ddd_ms_prestamos.dto.PrestamoResponse;

public interface TipoPrestamoService {

    //Diseño de los casos de uso (operaciones de negocio)

    //Valida si el monto solicitado es viable para el prestamo.
    //El monto maximo a prestar debera ser menor o igual al 60% del saldo
    //actual de la cuenta del cliente
    PrestamoResponse mostrar(PrestamoRequest request);
    PrestamoResponse buscar(PrestamoRequest request);



}
