package com.ms_servicios.controller;

import com.ms_servicios.dto.ServicioRequest;
import com.ms_servicios.entity.Servicio;
import com.ms_servicios.logic.ServicioLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
// http://localhost:8090/api/v1/servicios
@RestController
@RequestMapping("api/v1/servicios")
public class ServicioController {

    @Autowired
    private ServicioLogic service;

    @GetMapping
    public ResponseEntity<List<Servicio>> mostrar(){
        List<Servicio> servicios = service.mostrar();
        return new ResponseEntity<>(servicios, HttpStatusCode.valueOf(200));
    }

    @PostMapping
    public ResponseEntity<Servicio> guardar(@RequestBody ServicioRequest request){
        Servicio servicio = service.guardar(request);
        return new ResponseEntity<>(servicio, HttpStatusCode.valueOf(200));
    }

    @PutMapping
    public ResponseEntity<Servicio> actualizar(@RequestBody ServicioRequest request){
        Servicio servicio = service.actualizar(request);
        return new ResponseEntity<>(servicio, HttpStatusCode.valueOf(200));
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Servicio> buscar(@PathVariable int id){
        Servicio servicio = service.buscar(id);
        return new ResponseEntity<>(servicio, HttpStatusCode.valueOf(200));
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable int id){
        service.eliminar(id);
        return new ResponseEntity<>(HttpStatusCode.valueOf(204)); // 204 No Content
    }
}
