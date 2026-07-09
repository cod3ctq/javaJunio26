package com.ms_tipo_tarjeta.logic;

import com.ms_tipo_tarjeta.dto.TipoTarjetaRequest;
import com.ms_tipo_tarjeta.entity.TipoTarjeta;
import com.ms_tipo_tarjeta.repository.TipoTarjetaRepository;
import com.ms_tipo_tarjeta.service.TipoTarjetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;







@Service//Establece la responsabilidad de resolver la logica de negocios
public class TipoTarjetaLogic implements TipoTarjetaService {


    @Autowired//inyeccion de dependencias
    TipoTarjetaRepository repo; //(f1) atributo




    @Override
    public List mostrar() {return repo.findAll();
    }

    @Override
    public TipoTarjeta guarder(TipoTarjetaRequest request) {

        TipoTarjeta t = new TipoTarjeta();
        t.setDescripcion(request.getDescripcion());
        repo.save(t);
        return t;
    }

    @Override
    public TipoTarjeta actualizar(TipoTarjetaRequest request) {

        TipoTarjeta t = repo.findById(request.getTipoTId()).get();
        t.setDescripcion(request.getDescripcion());
        repo.save(t);
        return t;
    }

    @Override
    public TipoTarjeta buscar(int id) {
        return repo.findById(id).get();
    }

    @Override
    public String eliminar(int id) {
        repo.deleteById(id);
        return "Eliminado";
    }

    //@Autowired inyecta componentes que son autogestionados por el frameword
    //inyeccion de dependencias



}
