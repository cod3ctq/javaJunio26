package com.ddd_ms_catalogos.controller;

import com.ddd_ms_catalogos.dto.TipoPrestamoResponse;
import com.ddd_ms_catalogos.logic.TipoPrestamologic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ddd_ms_persistence.entity.TipoPrestamo;
import java.util.List;

@RestController
@RequestMapping("api/v1/catalogos/tipo-prestamo")
public class TipoPrestamoController {
    @Autowired
    TipoPrestamologic tpLogic;

    @GetMapping
    public ResponseEntity<List<TipoPrestamo>> mostrar(){
        List<TipoPrestamo> tipoPrestamos= tpLogic.mostrarTipoPrestamo();
        return  new ResponseEntity<List<TipoPrestamo>>(tipoPrestamos, HttpStatusCode.valueOf(200));
    }
    @GetMapping("/{id}")
    public ResponseEntity<TipoPrestamoResponse> buscar(@PathVariable int id){
        TipoPrestamoResponse tipoPrestamos  = tpLogic.obtenerTipoPrestamo(id);
        return new ResponseEntity<TipoPrestamoResponse>(tipoPrestamos,HttpStatusCode.valueOf(200));
    }
}
