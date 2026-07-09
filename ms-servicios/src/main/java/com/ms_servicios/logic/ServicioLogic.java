package com.ms_servicios.logic;

//Esta clase es de implementacion de la logica de
// negocios aqui se resuelven los metodos de implementacion de la capa anterior
//Resolucion de la capa de negocios

import com.ms_servicios.dto.ServicioRequest;
import com.ms_servicios.entity.Servicio;
import com.ms_servicios.repository.ServicioRepository;
import com.ms_servicios.service.ServiciosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service//Establece la responsabilidad de resolver la logica de negocios
public class ServicioLogic  implements ServiciosService {

    // @Autogired ddddd inyecta componentes que son autogestaonados por el frmeqorjn
    // SInyeccion de dependencias

    @Autowired//Inyeccion de dependencias
    ServicioRepository repo;//(f1) : atributo



    @Override
    public List mostrar() {
        return repo.findAll();
    }

    @Override
    public Servicio guardar(ServicioRequest request) {

      Servicio s = new Servicio();
      s.setConvenio(request.getConvenio());
      s.setDescripcion (request.getDescripcion());
      repo.save(s);
      return s;



    }

    @Override
    public Servicio actualizar(ServicioRequest request) {

        Servicio s = repo.findById(request.getServicioId()).get();
        s.setConvenio(request.getConvenio());
        s.setDescripcion (request.getDescripcion());
        repo.save(s);   //en este punto , save () actualiza el objeto ya existente
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
