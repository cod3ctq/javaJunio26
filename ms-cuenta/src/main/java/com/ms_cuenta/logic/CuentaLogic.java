package com.ms_cuenta.logic;

// Es de implementacion de la ligica de negocio, aca se resuelven los metodos de la capa 4 que es la de I(servicioService)

import com.ms_cuenta.dto.CuentaRequest;
import com.ms_cuenta.entity.Cuenta;
import com.ms_cuenta.repository.CuentaRepository;
import com.ms_cuenta.service.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service  //Stringframwork... type
public class CuentaLogic implements CuentaService {

    //inyeccion de dependencias de tipo: atributo (F1)
    @Autowired //Inyecta componentes que son autogestionados por el framework. Spring determina cuando y en que momento inicializar y destruir el objeto
    CuentaRepository repo;

    @Override
    public List mostrar() { // ya conoce la entidad
        return repo.findAll();
    }

    @Override
    public Cuenta guardar(CuentaRequest request) {
        Cuenta c =new Cuenta();
        c.setCuentaId(request.getCuentaId());
        c.setClienteId(request.getCuentaId());
        c.setTipoCuentaId(request.getTipoCuentaId());
        c.setNumCuenta(request.getNumCuenta());
        c.setClabe(request.getClabe());
        c.setSaldo(request.getSaldo());
        c.setFechaAP(request.getFechaAP());
        c.setStatus(request.getStatus());
        repo.save(c);
        return c; // en este punto la base ya lo guardo y tiene un id en la base de datos
    }

    @Override
    public Cuenta actualizar(CuentaRequest request) {
        //isEmpty, isPresente --> es como preguntar antes de buscar ( true o flase)
        Cuenta c =repo.findById(request.getCuentaId()).get();
        c.setCuentaId(request.getCuentaId());
        c.setClienteId(request.getCuentaId());
        c.setTipoCuentaId(request.getTipoCuentaId());
        c.setNumCuenta(request.getNumCuenta());
        c.setClabe(request.getClabe());
        c.setSaldo(request.getSaldo());
        c.setFechaAP(request.getFechaAP());
        c.setStatus(request.getStatus());
        repo.save(c); // sobre escribe ( es como el comportamiento de los mapas)
        return c;// en este punto la base ya lo guardo y tiene un id en la base de datos
    }

    @Override
    public Cuenta buscar(int id) {
        return repo.findById(id).get();
    }

    @Override
    public String eliminar(int id) {
        repo.deleteById(id);
        return "Eliminar";
    }
}
