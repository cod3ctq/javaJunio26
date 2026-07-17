package com.ddd_ms_catalogos.controller;

import com.ddd_ms_catalogos.dto.TipoCuentaResponse;
import com.ddd_ms_catalogos.logic.TipoCuentaLogic;
import com.ddd_ms_persistence.entity.TipoCuenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/catalogos/tipo-cuenta")
public class TipoCuentaController {

    @Autowired
    TipoCuentaLogic service;

    @GetMapping
    public ResponseEntity<List> mostrar(){
        List<TipoCuenta> tc = service.mostrar();
        return new ResponseEntity<List>(tc, HttpStatusCode.valueOf(200));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoCuentaResponse> buscar(@PathVariable int id){
        TipoCuentaResponse tc = service.buscar(id);
        return new ResponseEntity<TipoCuentaResponse>(tc, HttpStatusCode.valueOf(200));
    }

}
