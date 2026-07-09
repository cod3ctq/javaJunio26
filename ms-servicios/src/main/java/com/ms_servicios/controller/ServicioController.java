package com.ms_servicios.controller;

import com.ms_servicios.dto.ServicioRequest;
import com.ms_servicios.entity.Servicio;
import com.ms_servicios.logic.ServicioLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



/*
 6) En la capa 6 se establecen las rutas (endpoint) junto con los verbos de accion que le dicen al servidor que accion ejecutar
Es la creacion del contrato de funcionalidad que el servidor expone para ser consumido por los clientes
*/
//mexico/aguascalientes/aguascalientes/12345/
//{------------- URL ------------------}
//                             {endpoint}
//http://localhost:8090/api/v1/servicios
@RestController
@RequestMapping("api/v1/servicios") //Path a nivel controller
public class ServicioController {
    @Autowired
            //clase - objeto
    ServicioLogic service;
    // los verbos de accion refleja la intencion de la accion
    @GetMapping
    public ResponseEntity<List<Servicio>> mostrar() {
        List<Servicio> servicio = service.mostrar();
        return new ResponseEntity<List<Servicio>>(servicio, HttpStatusCode.valueOf(200));
    }
    // @RequestBody:Habilita la  manipulacion del cuerpo de la peticion
    @PostMapping
    public ResponseEntity<Servicio> guardar(@RequestBody ServicioRequest request) {
        Servicio servicio = service.guardar(request);
        return new ResponseEntity<Servicio>(servicio, HttpStatusCode.valueOf(200));
    }

    @PutMapping
    public ResponseEntity<Servicio> actualizar(@RequestBody ServicioRequest request) {
        Servicio servicio = service.actualizar(request);
        return new ResponseEntity<Servicio>(servicio, HttpStatusCode.valueOf(200));
    }

    //path varible: permite extraer los valores pasados como variables en las urls
    @GetMapping("/buscar/{id}") // {parametro}  va sin llaves
    public ResponseEntity<Servicio> buscar(@PathVariable int id) {
        Servicio servicio = service.buscar(id);
        return new ResponseEntity<Servicio>(servicio, HttpStatusCode.valueOf(200));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable int id) {
        String mensaje = service.eliminar(id);
        return new ResponseEntity<String>(mensaje, HttpStatusCode.valueOf(200));
    }
}