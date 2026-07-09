package com.ms_roles.logic;

import com.ms_roles.dto.RolesRequest;
import com.ms_roles.entity.Roles;
import com.ms_roles.repository.RolesRepository;
import com.ms_roles.service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RolesLogic implements RolesService {

    @Autowired
    RolesRepository repo;

    @Override
    public List mostrar() {


        return repo.findAll();
    }

    @Override
    public Roles guardar(RolesRequest request) {
        Roles s = new Roles();
        s.setDescripcion(request.getDescripcion());
        s.setSueldo(request.getSueldo());
        repo.save(s);//en este punto, save() guarda un objeto
        return s;
    }

    @Override
    public Roles actualizar(RolesRequest request) {
        Roles s = repo.findById(request.getRolId()).get();
        s.setDescripcion(request.getDescripcion());
        s.setDescripcion(request.getDescripcion());
        repo.save(s);//En este punto, save () actualiza el objeto
        return s;
    }

    @Override
    public Roles buscar(int id) {
        return repo.findById(id).get();
    }

    @Override
    public String eliminar(int id) {
        repo.deleteById(id);
        return "Eliminado";
    }
}
