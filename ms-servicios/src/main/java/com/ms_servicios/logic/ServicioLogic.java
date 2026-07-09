package com.ms_servicios.logic;

//Esta clase es de implementcion de la logica de negocio
//Aqui se resuelven los metodos de la capa anterior (4)


import com.ms_servicios.dto.ServicioRequest;
import com.ms_servicios.entity.Servicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ms_servicios.repository.ServicioRepository;
import com.ms_servicios.service.ServicioService;

import java.util.List;

@Service//Establece la responsabilidad de resolver la logica de negocio
public class ServicioLogic implements ServicioService {

    //@Autoeired: inyecta componente que son autogestionados por el framework
    //Spring determina cuando y en que momento inicializar y destruir el objeto
    @Autowired//inyeccion de dependencias
    ServicioRepository repo;//Forma 1: por atributos

    @Override
    public List mostrar() {
        return repo.findAll();
    }

    @Override
    public Servicio guardar(ServicioRequest request) {

        Servicio s = new Servicio();
        s.setConvenio(request.getConvenio());
        s.setDescripcion(request.getDescripcion());
        repo.save(s);
        return s;

    }

    @Override
    public Servicio actualizar(ServicioRequest request) {
        Servicio s = repo.findById(request.getServicioId()).get();
        s.setConvenio(request.getConvenio());
        s.setDescripcion(request.getDescripcion());
        repo.save(s);
        return s;
    }

    @Override
    public Servicio buscar(int id) {
        return repo.findById(id).get();
    }

    @Override
    public String eliminar(int id) {
        repo.deleteById(id);
        return "Eliminado";
    }
}
