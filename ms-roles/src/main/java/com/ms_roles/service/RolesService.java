package com.ms_roles.service;

import com.ms_roles.dto.RolesRequest;
import com.ms_roles.entity.Roles;

import java.util.List;

public interface RolesService {

    List mostrar();

    Roles guardar(RolesRequest request);

    Roles actualizar(RolesRequest request);

    Roles buscar(int id);

    String eliminar(int id);

    public interface ServicioService {
        List mostrar ();
        Roles guardar(RolesRequest request);
        Roles actualizar(RolesRequest request);
        Roles buscar(int id);
        String eliminar(int id);


    }
}
