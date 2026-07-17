package com.ddd_ms_catalogos.logic;



import com.ddd_ms_catalogos.constants.Mensajes;
import com.ddd_ms_catalogos.dto.TipoPrestamoResponse;
import com.ddd_ms_catalogos.exception.BusinessException;
import com.ddd_ms_catalogos.mapper.TipoPrestamoMapper;
import com.ddd_ms_catalogos.service.TipoPrestamoSevice;
import com.ddd_ms_persistence.entity.TipoPrestamo;
import com.ddd_ms_persistence.repository.TipoPrestamoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class TipoPrestamoLogic implements TipoPrestamoSevice {

    @Autowired
    TipoPrestamoRepository tpRepo;

    //Cliente HTTP, sirve para consumir otros endpoints desde el interior del backend
//    RestTemplate http = new RestTemplate();

    @Override
    public List<TipoPrestamoResponse> mostrar() {
        //Lista de objetos response que sera devuelta al final del metodo
        List<TipoPrestamoResponse> list = new ArrayList<TipoPrestamoResponse>();
        //ciclo que itera sobre la lista de entidades a fin de extraer de cada objeto de entidad sus valores y transformarlo a objetos response, Anadiendolo a la lista de response
        for(TipoPrestamo tp : tpRepo.findAll()) {
            list.add(TipoPrestamoMapper.toResponse(tp));
        }
        return list;
    }

    @Override
    public TipoPrestamoResponse buscar(int id) {
        Optional<TipoPrestamo> tipoPre  = tpRepo.findById(id);
        if(tipoPre.isPresent()){
            return TipoPrestamoMapper.toResponse(tipoPre.get());
        }
        throw new BusinessException(Mensajes.ACCOUNT_NOT_FOUND);
    }
}
