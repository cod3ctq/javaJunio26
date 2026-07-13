package com.ms_prestamos.logic;

import com.ms_prestamos.dto.PrestamoRequest;
import com.ms_prestamos.dto.PrestamoResponse;
import com.ms_prestamos.entity.Prestamos;
import com.ms_prestamos.mapper.PrestamoMapper;
import com.ms_prestamos.repository.PrestamoRepository;
import com.ms_prestamos.service.PrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service // Establece la responsabilidad de resolver la logica de negocio
public class PrestamoLogic implements PrestamoService {



    @Autowired
    PrestamoRepository repo;

    @Override
    public List mostrar() {

        PrestamoResponse response = null;
        List<PrestamoResponse> prestamos = new ArrayList<PrestamoResponse>();
        for (Prestamos p : repo.findAll()){
            response = PrestamoMapper.entityToResponse(p);
            prestamos.add(response);
        }
        return prestamos;
    }

    @Override
    public PrestamoResponse guardar(PrestamoRequest request) {

        // Creando un objeto entidad para guardar los datos extraidos del request
        Prestamos p = PrestamoMapper.requestToEntity(request);
        repo.save(p);
        PrestamoResponse response = PrestamoMapper.entityToResponse(p);
        return response;
    }

    @Override
    public PrestamoResponse actualizar(PrestamoRequest request) {

        Prestamos p = repo.findById(request.getPrestamoId()).get();
        p.setTipoId(request.getTipoId());
        p.setClienteId(request.getClienteId());
        p.setFecha(request.getFecha());
        p.setMonto(request.getMonto());
        p.setFechaFin(request.getFechaFin());
        p.setRestante(request.getRestante());
        repo.save(p);
        PrestamoResponse response = PrestamoMapper.entityToResponse(p);
        return response;
    }

    @Override
    public PrestamoResponse buscar(int id) {

        Prestamos p = repo.findById(id).get();
        PrestamoResponse response = PrestamoMapper.entityToResponse(p);
        return response;
    }

    @Override
    public String eliminar(int id) {

        repo.deleteById(id);
        return "Eliminado";
    }



}
