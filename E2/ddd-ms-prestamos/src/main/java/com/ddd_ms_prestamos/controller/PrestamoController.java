package com.ddd_ms_prestamos.controller;

import com.ddd_ms_prestamos.dto.PrestamoRequest;
import com.ddd_ms_prestamos.dto.PrestamoResponse;
import com.ddd_ms_prestamos.logic.PrestamoLogic;
import jakarta.validation.Valid;
import jakarta.ws.rs.POST;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("api/v1/prestamo")
public class PrestamoController {
    @Autowired
    PrestamoLogic service;

    @PostMapping("/validar")
    public ResponseEntity<PrestamoResponse> ValidarPrestamo( @RequestBody PrestamoRequest request){
        PrestamoResponse prestamoResponse= service.calculaPrestamo(request);
        return new ResponseEntity<PrestamoResponse>(prestamoResponse, HttpStatusCode.valueOf(200));
    }

    @PostMapping("/registrar")
    public ResponseEntity<PrestamoResponse> registrarPrestamo( @RequestBody PrestamoRequest request){
        PrestamoResponse prestamoResponse= service.registrarPrestamo(request);
        return new ResponseEntity<PrestamoResponse>(prestamoResponse, HttpStatusCode.valueOf(200));
    }
}
