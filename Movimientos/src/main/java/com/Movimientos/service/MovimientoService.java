package com.Movimientos.service;


import com.Movimientos.dto.MovimientoRequest;
import com.Movimientos.entity.Movimiento;

import java.util.List;

public interface MovimientoService {
    List mostrar();
    Movimiento guardar(MovimientoRequest request);
    Movimiento actualizar(MovimientoRequest resquest);
    Movimiento buscar(int id);
    String eliminar(int id);
}
