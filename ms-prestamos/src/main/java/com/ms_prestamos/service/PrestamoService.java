package com.ms_prestamos.service;

import com.ms_prestamos.dto.PrestamoRequest;
import com.ms_prestamos.entity.Prestamos;

import java.util.List;

public interface PrestamoService {

    List mostrar();
    Prestamos guardar (PrestamoRequest request);
    Prestamos actualizar (PrestamoRequest request);
    Prestamos buscar (int id);
    String eliminar (int id);
}
