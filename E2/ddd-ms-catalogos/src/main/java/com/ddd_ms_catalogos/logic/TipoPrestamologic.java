package com.ddd_ms_catalogos.logic;

import com.ddd_ms_catalogos.constants.Mensaje;
import com.ddd_ms_catalogos.dto.TipoPrestamoResponse;
import com.ddd_ms_catalogos.exception.NotFoundException;
import com.ddd_ms_catalogos.mapper.TipoPrestamoMapper;
import com.ddd_ms_catalogos.service.TipoPrestamoService;
import com.ddd_ms_persistence.entity.TipoPrestamo;
import com.ddd_ms_persistence.repository.TipoPrestamoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TipoPrestamologic implements TipoPrestamoService {
    @Autowired
    TipoPrestamoRepository tpRepo;

    @Override
    public List<TipoPrestamo> mostrarTipoPrestamo() {
      return tpRepo.findAll();
    }

    @Override
    public TipoPrestamoResponse obtenerTipoPrestamo(int id) {
        if (tpRepo.findById(id).isEmpty()){
            throw new NotFoundException(Mensaje.NOT_FOUND_TIPOPRESTAMO);
        }else{
            return TipoPrestamoMapper.toResponse(tpRepo.findById(id).get());
        }
    }


}
