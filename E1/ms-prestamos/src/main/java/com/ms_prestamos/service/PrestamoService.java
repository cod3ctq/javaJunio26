package com.ms_prestamos.service;

import com.ms_prestamos.dto.PrestamoRequest;
import com.ms_prestamos.dto.PrestamoResponse;
import com.ms_prestamos.entity.Prestamos;

import java.util.List;

//operaciones de negocio con enfoque tecnico

public interface PrestamoService {

    List mostrar();
    PrestamoResponse guardar (PrestamoRequest request);
    PrestamoResponse buscar (int id);
    String eliminar (int id);
    String desactivarPrestamo(int id);


}
