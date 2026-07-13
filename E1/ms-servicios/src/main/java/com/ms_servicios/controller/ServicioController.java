package com.ms_servicios.controller;


import com.ms_servicios.dto.ServicioRequest;
import com.ms_servicios.entity.Servicio;
import com.ms_servicios.logic.ServicioLogic;
import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//Mexico/Aguascalientes/Aguascalientes/2132/Emiliano Zapata/
//{..........URL..........................}
//                               {endpoint}

// http: //localhost:8090/api/v1/servicios
@RestController
@RequestMapping("api/v1/servicios")
public class ServicioController {


    @Autowired
    ServicioLogic service;


    @GetMapping
    public ResponseEntity<List<Servicio>> mostrar() {
        List<Servicio> servicios = service.mostrar();
        return new ResponseEntity<List<Servicio>>(servicios, HttpStatusCode.valueOf(200));
    }

    @PostMapping
    public ResponseEntity<Servicio> guardar(@RequestBody ServicioRequest request) {
        Servicio servicio = service.guardar(request);
        return new ResponseEntity<Servicio>(servicio, HttpStatusCode.valueOf(200));
    }
    // @RequestBody  : habilita la manipulacion del cuerpo de la peticion

    @PutMapping
    public ResponseEntity<Servicio> actualizar(@RequestBody ServicioRequest request) {
        Servicio servicio = service.actualizar(request);
        return new ResponseEntity<Servicio>(servicio, HttpStatusCode.valueOf(200));
    }
          // permite extraer los valores passados como variables en las urls
    @GetMapping("/buscar/{id}")
    public ResponseEntity<Servicio> buscar(@PathVariable int id) {
        Servicio servicio = service.buscar(id);
        return new ResponseEntity<Servicio>(servicio, HttpStatusCode.valueOf(200)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable int id) {
        String mensaje = service.eliminar(id);
        return new ResponseEntity<String>(mensaje, HttpStatusCode.valueOf(200));
    }


}
