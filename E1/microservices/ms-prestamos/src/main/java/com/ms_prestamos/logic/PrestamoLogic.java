package com.ms_prestamos.logic;


import com.ms_prestamos.constans.Mensajes;
import com.ms_prestamos.dto.PrestamoRequest;
import com.ms_prestamos.dto.PrestamoResponse;
import com.ms_prestamos.exception.ResourseNotFoundException;
import com.ms_prestamos.mapper.PrestamoMapper;
import com.ms_prestamos.entity.Prestamos;
import com.ms_prestamos.repository.PrestamoRepository;
import com.ms_prestamos.service.PrestamoService;
import org.apache.catalina.valves.JsonAccessLogValve;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

//Define que componente Resuelve la logica de negocios
@Service // Establece la responsabilidad de resolver la logica de negocio
public class PrestamoLogic implements PrestamoService {

    @Autowired
    PrestamoRepository repo;

    //sirve para consumir los end ppoints de la base
    RestTemplate http= new RestTemplate();

    @Override
    public List mostrar() {
        PrestamoResponse response= null;
        List<PrestamoResponse> prestamos = new ArrayList<PrestamoResponse>();
        for(Prestamos p: repo.findAllActive().get()){
            response = PrestamoMapper.entityToResponse(p);
            prestamos.add(response);
        }
        return prestamos;
    }

    @Override
    public PrestamoResponse guardar(PrestamoRequest request) {

        //invocar al servicio de  clientes para obtener el cliente id por rfc
        int clienteId = http.getForObject("http://localhost:8090/api/v1/cliente/buscar-rfc/"+request.getRfc(), Integer.class);

        Prestamos p = PrestamoMapper.requestToEntity(request,clienteId);
        repo.save(p);
        PrestamoResponse response = PrestamoMapper.entityToResponse(p);
        return response;
    }



    @Override
    public PrestamoResponse buscar(int id) {

        //Obtengo el opcinal devuelto por el findById
        Optional<Prestamos> prestamo = repo.findById(id);
        if(prestamo.isPresent()){
            Prestamos p = repo.findById(id).get();// si confirmo que exite l objeto
            PrestamoResponse response = PrestamoMapper.entityToResponse(p);
            return response;
        }else {
            //sino
            //devuelve una exceptcion
            throw  new ResourseNotFoundException(Mensajes.NOT_FOUND);
        }
    }

    @Override
    public String eliminar(int id) {

        repo.deleteById(id);
        return "Eliminado";
    }

    @Override
    public String desactivarPrestamo(int id) {
         repo.desactivarPrestamo(id);
        return "desactivo";
    }
}
