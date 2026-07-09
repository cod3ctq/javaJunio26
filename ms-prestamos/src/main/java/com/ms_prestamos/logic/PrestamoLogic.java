package com.ms_prestamos.logic;

import com.ms_prestamos.dto.PrestamoRequest;
import com.ms_prestamos.entity.Prestamos;
import com.ms_prestamos.repository.PrestamoRepository;
import com.ms_prestamos.service.PrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // Establece la responsabilidad de resolver la logica de negocio
public class PrestamoLogic implements PrestamoService {

    @Autowired
    PrestamoRepository repo;


    @Override
    public List mostrar() {
        return repo.findAll();
    }

    @Override
    public Prestamos guardar(PrestamoRequest request) {

        Prestamos p = new Prestamos();
        p.setTipoId(request.getTipoId());
        p.setClienteId(request.getClienteId());
        p.setFecha(request.getFecha());
        p.setMonto(request.getMonto());
        p.setFechaFin(request.getFechaFin());
        p.setRestante(request.getRestante());

        repo.save(p);
        return p;
    }

    @Override
    public Prestamos actualizar(PrestamoRequest request) {

        Prestamos p =repo.findById(request.getPrestamoId()).get();
        p.setTipoId(request.getTipoId());
        p.setClienteId(request.getClienteId());
        p.setFecha(request.getFecha());
        p.setMonto(request.getMonto());
        p.setFechaFin(request.getFechaFin());
        p.setRestante(request.getRestante());

        repo.save(p);
        return p;
    }

    @Override
    public Prestamos buscar(int id) {

        return repo.findById(id).get();
    }

    @Override
    public String eliminar(int id) {

        repo.deleteById(id);
        return "Eliminado";
    }
}
