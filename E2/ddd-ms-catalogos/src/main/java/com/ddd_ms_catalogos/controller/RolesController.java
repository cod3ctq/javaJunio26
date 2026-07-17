package com.ddd_ms_catalogos.controller;

import com.ddd_ms_catalogos.dto.RolesResponse;
import com.ddd_ms_catalogos.logic.RolesLogic;
import com.ddd_ms_persistence.entity.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/catalogos/roles")
public class RolesController {

    @Autowired
    RolesLogic service;

    @GetMapping
    public ResponseEntity<List> mostrar(){
        List<Roles> r = service.mostrar();
        return new ResponseEntity<List>(r, HttpStatusCode.valueOf(200));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RolesResponse> buscar(@PathVariable int id){
        RolesResponse r = service.buscar(id);
        return new ResponseEntity<RolesResponse>(r, HttpStatusCode.valueOf(200));


    }

}
