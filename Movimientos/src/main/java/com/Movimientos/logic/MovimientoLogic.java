package com.Movimientos.logic;


import com.Movimientos.dto.MovimientoRequest;
import com.Movimientos.entity.Movimiento;
import com.Movimientos.repository.MovimientosRepository;
import com.Movimientos.service.MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovimientoLogic implements MovimientoService {
    @Autowired
    MovimientosRepository repo;
    @Override
    public List mostrar() {
        return repo.findAll();
    }

    @Override
    public Movimiento guardar(MovimientoRequest request) {
        Movimiento m = new Movimiento();
        m.setFecha(request.getFecha());
        m.setMonto(request.getMonto());
        m.setTipo(request.getTipo());
        m.setCuentaId(request.getCuentaId());
        repo.save(m);
        return m;
    }

    @Override
    public Movimiento actualizar(MovimientoRequest resquest) {
        Movimiento m = repo.findById(resquest.getMovId()).get();
        m.setFecha(resquest.getFecha());
        m.setMonto(resquest.getMonto());
        m.setTipo(resquest.getTipo());
        m.setCuentaId(resquest.getCuentaId());
        repo.save(m);
        return m;
    }

    @Override
    public Movimiento buscar(int id) {
        Movimiento m = repo.findById(id).get();
        return m;
    }

    @Override
    public String eliminar(int id) {
        repo.deleteById(id);
        return "Eliminado";
    }
}
