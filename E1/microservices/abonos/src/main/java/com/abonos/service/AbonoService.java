package com.abonos.service;

import com.abonos.dto.AbonoRequest;
import com.abonos.entity.Abono;

import java.util.List;

public interface AbonoService {
    List mostrar();
    Abono guardar(AbonoRequest request);
    Abono actualizar(AbonoRequest request);
    Abono buscar (int id);
    String eliminar (int id);
}
