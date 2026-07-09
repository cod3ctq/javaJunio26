package com.ms_empleados.logic;


import com.ms_empleados.dto.EmpleadoRequest;
import com.ms_empleados.entity.Empleados;
import com.ms_empleados.repository.EmpleadosRepository;
import com.ms_empleados.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoLogic implements EmpleadoService {


    @Autowired
    EmpleadosRepository repo;

    @Override
    public List mostrar(){


        return repo.findAll();
    }
    @Override
    public Empleados guardar(EmpleadoRequest request){
        Empleados e = new Empleados();
        e.setRolId(request.getRolId());
        e.setNombre(request.getNombre());
        e.setApP(request.getApP());
        e.setApA(request.getApM());
        e.setFechaIn(request.getFechaIn());
        e.setCorreo(request.getCorreo());
        e.setTelefono(request.getTelefono());
        e.setStatus(request.getStatus());
        repo.save(e);
        return e;
    }
    @Override
    public Empleados actualizar (EmpleadoRequest request){
        Empleados e = new Empleados();
        e.setRolId(request.getRolId());
        e.setNombre(request.getNombre());
        e.setApP(request.getApP());
        e.setApA(request.getApM());
        e.setFechaIn(request.getFechaIn());
        e.setCorreo(request.getCorreo());
        e.setTelefono(request.getTelefono());
        e.setStatus(request.getStatus());
        repo.save(e);
        return e;
    }
    @Override
    public Empleados buscar(int id){
        return repo.findById(id).get();
    }
    @Override
    public String eliminar(int id){
        repo.deleteById(id);
        return "Eliminado";
    }

}
