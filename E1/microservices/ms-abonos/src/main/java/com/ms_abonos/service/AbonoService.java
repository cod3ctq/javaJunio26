package com.ms_abonos.service;

import com.ms_abonos.dto.AbonoRequest;
import com.ms_abonos.entity.Abono;

import java.util.List;
//(4)
public interface AbonoService {
    List mostrar();
    Abono guardar (AbonoRequest request);
    Abono actualizar (AbonoRequest request);
    Abono buscar (int id);
    String eliminar (int id);
}
