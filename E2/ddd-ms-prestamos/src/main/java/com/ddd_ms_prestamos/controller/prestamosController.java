package com.ddd_ms_prestamos.controller;

import com.ddd_ms_persistence.entity.Prestamo;
import com.ddd_ms_prestamos.dto.PrestamoRequest;
import com.ddd_ms_prestamos.dto.PrestamoResponse;
import com.ddd_ms_prestamos.logic.PrestamoLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 @RestController
@RequestMapping ("api/v1/prestamo")
public class prestamosController {

  @Autowired
  PrestamoLogic service;

  @PostMapping("/validar")
  public ResponseEntity<PrestamoResponse> validarPrestamo(@RequestBody PrestamoRequest request) {
      PrestamoResponse response = service.calculaPrestamo(request);
      return new ResponseEntity<PrestamoResponse>(response, HttpStatusCode.valueOf(200));
  }

     @PostMapping
     public ResponseEntity<PrestamoResponse> registarPrestamo(@RequestBody PrestamoRequest request) {
         PrestamoResponse response = service.registrarPrestamo(request);
         return new ResponseEntity<PrestamoResponse>(response, HttpStatusCode.valueOf(200));
     }

 }
