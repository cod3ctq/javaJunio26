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
@RequestMapping("api/v1/catalogo/tipoPrestamo")
public class TipoPrestamoController {

    @Autowired
    TipoPrestamoLogic tipoPre;

    @GetMapping
    public ResponseEntity<List<TipoPrestamoResponse>> mostrar(){
        List<TipoPrestamoResponse> tipoPrestamo = tipoPre.mostrar();
        return new ResponseEntity<List<TipoPrestamoResponse>>(tipoPrestamo,HttpStatusCode.valueOf(200));
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<TipoPrestamoResponse> buscar(@PathVariable int id){
        TipoPrestamoResponse tipoPrestamo = tipoPre.buscar(id);
        return new ResponseEntity<TipoPrestamoResponse>(tipoPrestamo, HttpStatusCode.valueOf(200));
    }


//    //Este genera el codigo 200 por default
//    @GetMapping("/buscar/{id}")
//    public ResponseEntity<TipoPrestamoResponse> buscar(@PathVariable int id){
//        TipoPrestamoResponse response = tipoPre.busquar(id);
//        return ResponseEntity.ok(response);
//    }

}