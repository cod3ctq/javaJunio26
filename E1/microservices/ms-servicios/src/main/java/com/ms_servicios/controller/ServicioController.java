package com.ms_servicios.controller;

import com.ms_servicios.dto.ServicioRequest;
import com.ms_servicios.entity.Servicio;
import com.ms_servicios.logic.ServicioLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//URL
//Mexico/Aguascalientes/Aguascalientes/97473/Emiliano Zapata/#472
// {------------URL----------------------}
//                              {endpoint}
// http://localhost:8090/api/v1/servicios
@RestController
@RequestMapping("api/v1/servicios") //Path a nivel controlador
public class ServicioController {

    @Autowired
    ServicioLogic service;

    @GetMapping
    public ResponseEntity<List<Servicio>> mostrar(){
        List<Servicio> servicios = service.mostrar();
        return new ResponseEntity<List<Servicio>>(servicios, HttpStatusCode.valueOf(200));
    }
    //@RequestBody : habilita la manipulacion del cuerpo de la peticion
    @PostMapping
    public ResponseEntity<Servicio> guardar(@RequestBody ServicioRequest request){
        Servicio servicio = service.guardar(request);
        return new ResponseEntity<Servicio>(servicio, HttpStatusCode.valueOf(200));
    }
    @PutMapping
    public ResponseEntity<Servicio> actualizar(@RequestBody ServicioRequest request){
        Servicio servicio = service.actualizar(request);
        return new ResponseEntity<Servicio>(servicio, HttpStatusCode.valueOf(200));
    }
    //@PathVariable : permite extraer los valores pasados como variables en las urls
    @GetMapping("/buscar/{id}") //{parametro}
    public ResponseEntity<Servicio> buscar(@PathVariable int id){
        Servicio servicio = service.buscar(id);
        return new ResponseEntity<Servicio>(servicio, HttpStatusCode.valueOf(200));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable int id){
        String mensaje = service.eliminar(id);
        return new ResponseEntity<String>(mensaje, HttpStatusCode.valueOf(200));
    }
}
