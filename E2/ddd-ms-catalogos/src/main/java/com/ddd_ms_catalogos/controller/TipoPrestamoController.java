package com.ddd_ms_catalogos.controller;

import com.ddd_ms_catalogos.dto.TipoPrestamoResponse;
import com.ddd_ms_catalogos.logic.TipoPrestamoLogic;
import com.ddd_ms_persistence.entity.TipoPrestamo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/catalogos/tipo-prestamo")
public class TipoPrestamoController {

    @Autowired
    TipoPrestamoLogic service;

    @GetMapping
    public ResponseEntity<List> mostrar(){
        List<TipoPrestamo> lista = service.mostrar();
        return new ResponseEntity<List>(lista, HttpStatusCode.valueOf(200));
    }
    @GetMapping("/{id}")
    public ResponseEntity<TipoPrestamoResponse> buscar(@PathVariable int id){
        TipoPrestamoResponse tp = service.buscar(id);
        return new ResponseEntity<TipoPrestamoResponse>(tp, HttpStatusCode.valueOf(200));
    }

}
