package com.ms_servicios.logic;

import com.ms_servicios.dto.ServicioRequest;
import com.ms_servicios.entity.Servicio;
import com.ms_servicios.repository.ServicioRepository;
import com.ms_servicios.service.ServicioService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class ServicioLogic implements ServicioService {

    @Autowired
    private ServicioRepository repo;

    @Override
    public List<Servicio> mostrar() {
        return repo.findAll();
    }

    @Override
    public Servicio guardar(ServicioRequest request) {
        Servicio s = new Servicio();
        s.setConvenio(request.getConvenio());
        s.setDescripcion(request.getDescripcion());
        return repo.save(s);
    }

    @Override
    public Servicio actualizar(ServicioRequest request) {
        Servicio s = repo.findById(request.getServicioId())
                .orElseThrow(() -> new RuntimeException("Servicio no encontrado"));
        s.setConvenio(request.getConvenio());
        s.setDescripcion(request.getDescripcion());
        return repo.save(s);
    }

    @Override
    public Servicio buscar(int id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Servicio no encontrado"));
    }

    @Override
    public void eliminar(int id) {
        repo.deleteById(id);
    }
}
