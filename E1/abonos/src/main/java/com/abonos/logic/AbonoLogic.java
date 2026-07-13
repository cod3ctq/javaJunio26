package com.abonos.logic;

import com.abonos.dto.AbonoRequest;
import com.abonos.entity.Abono;
import com.abonos.repository.AbonoRepository;
import com.abonos.service.AbonoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AbonoLogic implements AbonoService {
    //Inyeccion de dependencias
    @Autowired
    AbonoRepository repo;

    @Override
    public List mostrar() {
        return repo.findAll();
    }

    @Override
    public Abono guardar(AbonoRequest request) {
        Abono abono = new Abono();
        abono.setPrestamoId(request.getPrestamoId());
        abono.setFecha(request.getFecha());
        abono.setMonto(request.getMonto());
        abono.setMedioPagoId(request.getMedioPagoId());
        repo.save(abono);
        return abono;
    }

    @Override
    public Abono actualizar(AbonoRequest request) {
        Abono abono = repo.findById(request.getAbonoId()).get();
        abono.setPrestamoId(request.getPrestamoId());
        abono.setFecha(request.getFecha());
        abono.setMonto(request.getMonto());
        abono.setMedioPagoId(request.getMedioPagoId());
        repo.save(abono);
        return abono;
    }

    @Override
    public Abono buscar(int id) {
        return repo.findById(id).get();
    }

    @Override
    public String eliminar(int id) {
        repo.deleteById(id);
        return "Eliminado";
    }

}
