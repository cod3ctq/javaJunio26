package com.ddd_ms_catalogos.logic;

import com.ddd_ms_catalogos.constants.Mensajes;
import com.ddd_ms_catalogos.dto.TipoPrestamoResponse;
import com.ddd_ms_catalogos.exception.NotFoundException;
import com.ddd_ms_catalogos.mapper.TipoPrestamoMapper;
import com.ddd_ms_catalogos.service.TipoPrestamoService;
import com.ddd_ms_persistence.entity.TipoPrestamo;
import com.ddd_ms_persistence.repository.TipoPrestamoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoPrestamoLogic implements TipoPrestamoService {


    @Autowired
    TipoPrestamoRepository repo;

    @Override
    public List mostrar() {
        return repo.findAll();
    }

    @Override
    public TipoPrestamoResponse buscar(int id) {

        Optional<TipoPrestamo> opt = repo.findById(id);
        if(opt.isPresent()){
            return TipoPrestamoMapper.toResponse(opt.get());
        }else{
            throw new NotFoundException(Mensajes.NOT_FOUND);
        }

    }
}
