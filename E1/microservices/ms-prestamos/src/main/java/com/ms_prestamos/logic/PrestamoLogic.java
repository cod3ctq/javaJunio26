package com.ms_prestamos.logic;

import com.ms_prestamos.constants.Mensajes;
import com.ms_prestamos.dto.PrestamoRequest;
import com.ms_prestamos.dto.PrestamoResponse;
import com.ms_prestamos.dto.PrestamosResponse;
import com.ms_prestamos.entity.Prestamos;
import com.ms_prestamos.exception.ResourceNotFoundException;
import com.ms_prestamos.mapper.PrestamoMapper;
import com.ms_prestamos.repository.PrestamoRepository;
import com.ms_prestamos.service.PrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service // Establece la responsabilidad de resolver la logica de negocio
public class PrestamoLogic implements PrestamoService {

    @Autowired
    PrestamoRepository repo;

    //Cliente http, sirve para consumir ptros edpoinds desde el interior del backend
    RestTemplate http = new RestTemplate();
    @Override
    public List mostrar() {
        PrestamoResponse responce = null;
        List<PrestamoResponse> prestamos = new ArrayList<PrestamoResponse>();
        for (Prestamos p: repo.findAllActive().get()){//Invoca al metodo de buscar con status 1
            response= PrestamoMapper.entityToResponse(p);
            prestamos.add(response);
        }
        return prestamos;

    }

    @Override
    public PrestamoResponse guardar (PrestamoRequest request) {
        int clienteId= http.getForObject(
                "http://localhost:8090/api/v1/cliente/buscar-rfc/"+request.getRfc(),Integer.class);
        //Creando un objeto para guardar los datos extaridos del request
        Prestamos p = PrestamoMapper.requestToEntity(request, clienteId);
        repo.save(p);
        PrestamoResponse response=PrestamoMapper.entityToResponse(p);
        return response;



    }

    @Override
    public PrestamoResponse buscar(int id) {
        Optional <Prestamos> prestamo = repo.findById(id);

        if (prestamo.isPresent()){//Si confirmo que existe el objeto
            Prestamos p = prestamo.get();//extraigo el objeto del opcional
            PrestamoResponse response = PrestamoMapper.entityToResponse(p);
            return response;

        }else {//si no...
            //devuelvo una excepcipn
            throw  new ResourceNotFoundException(Mensajes.NOT_FOUND);


        }
    }


    @Override
    public String eliminar(int id) {

        repo.deleteById(id);
        return "Eliminado";
    }

    @Override
    public String desactivarPrestamo(int id)
        repo.desactivarPrestamo (id);
        retur
}
