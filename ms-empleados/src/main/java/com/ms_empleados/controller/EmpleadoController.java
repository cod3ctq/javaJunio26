package com.ms_empleados.controller;

import com.ms_empleados.dto.EmpleadoRequest;
import com.ms_empleados.entity.Empleados;
import com.ms_empleados.logic.EmpleadoLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/empleados")
public class EmpleadoController {


    @Autowired
    EmpleadoLogic service;
    @GetMapping
    public ResponseEntity<List<Empleados>> mostrar() {
        List<Empleados> empleados = service.mostrar();
        return new ResponseEntity<List<Empleados>>(empleados, HttpStatusCode.valueOf(200));
    }
    //Abilita la mamniupulacion del cuerpo de la peticion
    @PostMapping
    public ResponseEntity<Empleados> guardar(@RequestBody EmpleadoRequest request) {
        Empleados empleados = service.guardar(request);
        return new ResponseEntity<Empleados>(empleados, HttpStatusCode.valueOf(200));
    }
    @PutMapping
    public ResponseEntity<Empleados> actualizar(@RequestBody EmpleadoRequest request) {
        Empleados empleados = service.actualizar(request);
        return new ResponseEntity<Empleados>(empleados, HttpStatusCode.valueOf(200));
    }
    //@PathVariable : Permite extraer los valores pasados como variables en las urls
    @GetMapping ("/buscar/{id}")//{parametro}
    public ResponseEntity<Empleados>buscar(@PathVariable int id){
        Empleados empleados = service.buscar(id);
        return new ResponseEntity<Empleados>(empleados, HttpStatusCode.valueOf(200));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String>eliminar(@PathVariable int id){
        String mensaje = service.eliminar(id);
        return new ResponseEntity<String>(mensaje, HttpStatusCode.valueOf(200));
    }
}

