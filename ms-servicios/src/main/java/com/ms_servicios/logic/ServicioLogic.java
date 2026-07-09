package com.ms_servicios.logic;
// Es de implementacion de la ligica de negocio, aca se resuelven los metodos de la capa 4 que es la de I(servicioService)

import com.ms_servicios.dto.ServicioRequest;
import com.ms_servicios.entity.Servicio;
import com.ms_servicios.repository.ServicioRepository;
import com.ms_servicios.service.ServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service //Stringframwork... type
public class ServicioLogic implements ServicioService {
    //** La F2 es con un constructor
    //inyeccion de dependencias de tipo: atributo (F1)
    @Autowired //Inyecta componentes que son autogestionados por el framework. Spring determina cuando y en que momento inicializar y destruir el objeto
    ServicioRepository repo;

    @Override
    public List mostrar() {// ya conoce la entidad
        return repo.findAll();
    }

    @Override
    public Servicio guardar(ServicioRequest request) {

        Servicio s = new Servicio();
        s.setConvenio(request.getConvenio());
        s.setDescription(request.getDescription());
        repo.save(s);
        return s;// en este punto la base ya lo guardo y tiene un id en la base de datos
    }

    @Override
    public Servicio actualizar(ServicioRequest request) {
        //isEmpty, isPresente --> es como preguntar antes de buscar ( true o flase)
        Servicio s = repo.findById(request.getServicioId()).get();
        s.setConvenio(request.getConvenio());
        s.setDescription(request.getDescription());
        repo.save(s); // sobre escribe ( es como el comportamiento de los mapas)
        return s;// en este punto la base ya lo guardo y tiene un id en la base de datos
    }

    @Override
    public Servicio buscar(int id) {
        return repo.findById(id).get();
    }

    @Override
    public String eliminar(int id) {
        repo.deleteById(id);
        return "Eliminar";
    }
}