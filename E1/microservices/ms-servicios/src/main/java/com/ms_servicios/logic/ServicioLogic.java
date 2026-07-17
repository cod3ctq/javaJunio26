package com.ms_servicios.logic;

// Esta clase es de implementacion de la logica de negocio.
// Aqui se resuelven los metodos de la capa anterior (4) (Lóogica de negocios)

import com.ms_servicios.dto.ServicioRequest;
import com.ms_servicios.entity.Servicio;
import com.ms_servicios.repository.ServicioRepository;
import com.ms_servicios.service.ServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // Establece la responsabilidad de resolver la logica de negocio
public class ServicioLogic implements ServicioService {

    //  Inyección de dependencias
    // @Autowired : Inyecta componentes de que son autogestionados por el framework
    // Spring determina cuando y en qué momento inicializar y destruir el objeto

    // El objeto va a ser instanciado por el framework
    @Autowired // Inyección de dependencias
    ServicioRepository repo; // (F1) : atributo



    @Override
    public List mostrar() {
        return repo.findAll();
    }

    @Override
    public Servicio guardar(ServicioRequest request) {

        Servicio s = new Servicio();
        s.setConvenio(request.getConvenio());
        s.setDescripcion(request.getDescripcion());
        repo.save(s); // En este punto, save() guarda un objeto nuevo
        return s;
    }

    @Override
    public Servicio actualizar(ServicioRequest request) {

        Servicio s = repo.findById(request.getServicioId()).get();
        s.setConvenio(request.getConvenio());
        s.setDescripcion(request.getDescripcion());
        repo.save(s); // En este punto, save() actualiza el objeto ya existente
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

    // Se desarrollan las operaciones de negocio estableciendo la responsabilidad en esta clase con el estereotipo @Service
    // y se inyecta el componente que interactua con la base de datos (Repository) con el estereotipo @Autowired
}
