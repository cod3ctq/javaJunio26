package com.ddd_ms_catalogos.mapper;

import com.ddd_ms_catalogos.dto.RolesResponse;
import com.ddd_ms_persistence.entity.Roles;

public class RolesMapper {

    public static RolesResponse toResponse (Roles entity){
        return new RolesResponse(entity.getDescripcion(), entity.getSueldo());
    }
}
