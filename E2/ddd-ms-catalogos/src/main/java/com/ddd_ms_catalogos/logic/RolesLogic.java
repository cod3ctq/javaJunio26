package com.ddd_ms_catalogos.logic;

import com.ddd_ms_catalogos.dto.RolesResponse;
import com.ddd_ms_catalogos.exception.NotFoundException;
import com.ddd_ms_catalogos.mapper.RolesMapper;
import com.ddd_ms_catalogos.mensajes.Mensajes;
import com.ddd_ms_catalogos.service.RolesService;
import com.ddd_ms_persistence.entity.Roles;
import com.ddd_ms_persistence.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolesLogic implements RolesService {

    @Autowired
    RolesRepository repo;

    @Override
    public List mostrar() {
        return repo.findAll();
    }

    @Override
    public RolesResponse buscar(int id) {

        Optional<Roles> r = repo.findById(id);
        if(r.isPresent()){
            return RolesMapper.toResponse(r.get());
        } else{
            throw new NotFoundException(Mensajes.ROLE_NOT_FOUND);
        }
    }
}
