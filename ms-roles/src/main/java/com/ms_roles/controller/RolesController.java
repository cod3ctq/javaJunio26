package com.ms_roles.controller;

import com.ms_roles.dto.RolesRequest;
import com.ms_roles.entity.Roles;
import com.ms_roles.logic.RolesLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/roles")//Path a nivel controlador
public class RolesController {

    @Autowired
    RolesLogic service;
    @GetMapping
    public ResponseEntity<List<Roles>> mostrar() {
        List<Roles> roles = service.mostrar();
        return new ResponseEntity<List<Roles>>(roles, HttpStatusCode.valueOf(200));
    }
    //Abilita la mamniupulacion del cuerpo de la peticion
    @PostMapping
    public ResponseEntity<Roles> guardar(@RequestBody RolesRequest request) {
        Roles roles = service.guardar(request);
        return new ResponseEntity<Roles>(roles, HttpStatusCode.valueOf(200));
    }
    @PutMapping
    public ResponseEntity<Roles> actualizar(@RequestBody RolesRequest request) {
        Roles roles = service.actualizar(request);
        return new ResponseEntity<Roles>(roles, HttpStatusCode.valueOf(200));
    }
    //@PathVariable : Permite extraer los valores pasados como variables en las urls
    @GetMapping ("/buscar/{id}")//{parametro}
    public ResponseEntity<Roles>buscar(@PathVariable int id){
        Roles roles = service.buscar(id);
        return new ResponseEntity<Roles>(roles, HttpStatusCode.valueOf(200));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String>eliminar(@PathVariable int id){
        String mensaje = service.eliminar(id);
        return new ResponseEntity<String>(mensaje, HttpStatusCode.valueOf(200));
    }
}
