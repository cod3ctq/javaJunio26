package com.ms_abonos.logic;

import com.ms_abonos.dto.AbonoRequest;
import com.ms_abonos.entity.Abono;
import com.ms_abonos.repository.AbonoRepository;
import com.ms_abonos.service.AbonoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AbonoLogic  implements AbonoService {
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