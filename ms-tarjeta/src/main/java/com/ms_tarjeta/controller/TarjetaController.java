package com.ms_tarjeta.controller;

import com.ms_tarjeta.dto.TarjetaRequest;
import com.ms_tarjeta.entity.Tarjeta;
import com.ms_tarjeta.logic.TarjetaLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("api/v1/tarjeta")

public class TarjetaController {

    @Autowired
    TarjetaLogic service;


    @GetMapping
    public ResponseEntity<List<Tarjeta>> mostrar() {
        List<Tarjeta> servicios = service.mostrar();
        return new ResponseEntity<List<Tarjeta>>(servicios, HttpStatusCode.valueOf(200));
    }

    @PostMapping
    public ResponseEntity<Tarjeta> guardar(@RequestBody TarjetaRequest request) {
        Tarjeta servicio = service.guardar(request);
        return new ResponseEntity<Tarjeta>(servicio, HttpStatusCode.valueOf(200));
    }
    // @RequestBody  : habilita la manipulacion del cuerpo de la peticion

    @PutMapping
    public ResponseEntity<Tarjeta> actualizar(@RequestBody TarjetaRequest request) {
        Tarjeta servicio = service.actualizar(request);
        return new ResponseEntity<Tarjeta>(servicio, HttpStatusCode.valueOf(200));
    }
    // permite extraer los valores passados como variables en las urls
    @GetMapping("/buscar/{id}")
    public ResponseEntity<Tarjeta> buscar(@PathVariable int id) {
        Tarjeta servicio = service.buscar(id);
        return new ResponseEntity<Tarjeta>(servicio, HttpStatusCode.valueOf(200)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable int id) {
        String mensaje = service.eliminar(id);
        return new ResponseEntity<String>(mensaje, HttpStatusCode.valueOf(200));
    }








}
