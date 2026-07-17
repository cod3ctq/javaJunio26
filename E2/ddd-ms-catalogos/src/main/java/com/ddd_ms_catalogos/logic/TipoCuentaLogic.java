package com.ddd_ms_catalogos.logic;

import com.ddd_ms_catalogos.dto.TipoCuentaResponse;
import com.ddd_ms_catalogos.exception.NotFoundException;
import com.ddd_ms_catalogos.mapper.TipoCuentaMapper;
import com.ddd_ms_catalogos.mensajes.Mensajes;
import com.ddd_ms_catalogos.service.TipoCuentaService;
import com.ddd_ms_persistence.entity.TipoCuenta;
import com.ddd_ms_persistence.repository.TipoCuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoCuentaLogic implements TipoCuentaService {

    @Autowired
    TipoCuentaRepository repo;

    @Override
    public List mostrar() {
        return repo.findAll();
    }

    @Override
    public TipoCuentaResponse buscar(int id) {

        Optional<TipoCuenta> tc = repo.findById(id);
        if(tc.isPresent()){
            return TipoCuentaMapper.toResponse(tc.get());
        } else {
            throw new NotFoundException(Mensajes.COUNT_TYPE_NOT_FOUND);
        }
    }
}
