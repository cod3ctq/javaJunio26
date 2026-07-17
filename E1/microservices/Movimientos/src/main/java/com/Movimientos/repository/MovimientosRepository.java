package com.Movimientos.repository;

import com.Movimientos.entity.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovimientosRepository  extends JpaRepository<Movimiento, Integer> {
}
