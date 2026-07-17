package com.ddd_ms_catalogos.controller;

import com.ddd_ms_catalogos.dto.TipoPrestamoResponse;
import com.ddd_ms_catalogos.logic.TipoPrestamoLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/catalogos/Tipo-prestamo")
public class TipoPrestamoController {


        @Autowired
        TipoPrestamoLogic service;

        @GetMapping ("/mostrar")
        public ResponseEntity<List> mostrar (){
            List<TipoPrestamoResponse> lista = service.mostrar();
            return new ResponseEntity<List>(lista, HttpStatusCode.valueOf(200));
        }

        @GetMapping("/{id}")
        public ResponseEntity<TipoPrestamoResponse> buscar (@PathVariable int id){
            TipoPrestamoResponse response = service.buscar(id);
            return new ResponseEntity<TipoPrestamoResponse>(tp, HttpStatusCode.valueOf(200));{
            }
}
