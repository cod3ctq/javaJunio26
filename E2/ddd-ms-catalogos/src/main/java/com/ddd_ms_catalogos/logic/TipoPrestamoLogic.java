package com.ddd_ms_catalogos.logic;

import com.ddd_ms_catalogos.dto.TipoPrestamoResponse;
import com.ddd_ms_catalogos.exception.NotFoundException;
import com.ddd_ms_catalogos.mapper.TipoPrestamoMapper;
import com.ddd_ms_catalogos.mensajes.Mensajes;
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

        Optional<TipoPrestamo> tp = repo.findById(id);
        if(tp.isPresent()){
            TipoPrestamo p = tp.get();
            return TipoPrestamoMapper.toResponse(p);
        }else{
            throw new NotFoundException(Mensajes.LOAN_TYPE_NOT_FOUND);
        }
    }
}
