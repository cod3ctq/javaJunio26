package com.ddd_ms_catalogos.service;

import com.ddd_ms_catalogos.dto.RolesResponse;

import java.util.List;

public interface RolesService {

    List mostrar();
    RolesResponse buscar(int id);


}
