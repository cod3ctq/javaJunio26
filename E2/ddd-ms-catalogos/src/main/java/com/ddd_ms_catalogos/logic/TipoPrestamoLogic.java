package com.ddd_ms_catalogos.logic;

import Mapper.TipoPrestamoMapper;
import com.ddd_ms_catalogos.constants.Mensajes;
import com.ddd_ms_catalogos.dto.TipoPrestamoResponse;
import com.ddd_ms_catalogos.exception.NotFoudException;
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
    public List<TipoPrestamo> mostrar() {
        return repo.findAll();
    }

    @Override
    public TipoPrestamoResponse buscar(int id) {
        Optional<TipoPrestamo>otp= repo.findById(id);
        if(otp.isPresent()){
            return TipoPrestamoMapper.toResponse(otp.get());
        }else{
            throw new NotFoudException(Mensajes.NOT_FOUND);
        }
    }
}
