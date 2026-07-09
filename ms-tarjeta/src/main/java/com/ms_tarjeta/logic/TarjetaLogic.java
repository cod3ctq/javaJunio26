package com.ms_tarjeta.logic;

import com.ms_tarjeta.dto.TarjetaRequest;
import com.ms_tarjeta.entity.Tarjeta;
import com.ms_tarjeta.repository.TarjetaRepository;
import com.ms_tarjeta.service.TarjetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;




@Service
public class TarjetaLogic implements TarjetaService{

  @Autowired
    TarjetaRepository repo;



    @Override
    public List mostrar() {return repo.findAll();
    }



    @Override
    public Tarjeta guardar(TarjetaRequest request) {
        Tarjeta t = new Tarjeta();
        t.setCuenta(request.getCuenta());
        t.setTipoTarjeta(request.getTipoTarjeta());
        t.setNumTarjeta(request.getNumTarjeta());
        t.setNip(request.getNip());
        t.setFechaVen(request.getFechaVen());
        t.setStatus(request.getStatus());
        repo.save(t);
        return t;
    }

    @Override
    public Tarjeta actualizar(TarjetaRequest request) {
        Tarjeta t = repo.findById(request.getTarjeta()).get();
        t.setCuenta(request.getCuenta());
        t.setTipoTarjeta(request.getTipoTarjeta());
        t.setNumTarjeta(request.getNumTarjeta());
        t.setNip(request.getNip());
        t.setFechaVen(request.getFechaVen());
        t.setStatus(request.getStatus());
        repo.save(t);
        return t;
    }

    @Override
    public Tarjeta buscar(int id) {
        return repo.findById(id).get();
    }

    @Override
    public String eliminar(int id) {
        repo.deleteById(id);
        return "Eliminado";
    }
}
