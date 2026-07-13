package com.ms_prestamos.controller;

import com.ms_prestamos.dto.PrestamoRequest;
import com.ms_prestamos.dto.PrestamoResponse;
import com.ms_prestamos.logic.PrestamoLogic;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/prestamos")
public class PrestamoController {

    @Autowired
    PrestamoLogic prestamo;

    @GetMapping
    public ResponseEntity<List<PrestamoResponse>> mostrar(){
        List<PrestamoResponse> prestamos = prestamo.mostrar();
        return new ResponseEntity<List<PrestamoResponse>>(prestamos, HttpStatusCode.valueOf(200));
    }

    @PostMapping
    public ResponseEntity<PrestamoResponse> guardar(@Valid @RequestBody PrestamoRequest request){
        PrestamoResponse prestamos = prestamo.guardar(request);
        return new ResponseEntity<PrestamoResponse>(prestamos, HttpStatusCode.valueOf(200));
    }

    // Se borró el metodo actualizar debido a que por regla de negocio no es requerido
    // actualizar los datos de un prestamo una vez que se ha concretado.

    @GetMapping("/buscar/{id}")
    public ResponseEntity<PrestamoResponse> buscar(@PathVariable int id){
        PrestamoResponse prestamos = prestamo.buscar(id);
        return new ResponseEntity<PrestamoResponse>(prestamos, HttpStatusCode.valueOf(200));
    }

    // Borrado logico
    @DeleteMapping("/{id}")
    public ResponseEntity<String> desactivar(@PathVariable int id){
        String mensaje = prestamo.desactivarPrestamo(id);
        return new ResponseEntity<String>(mensaje, HttpStatusCode.valueOf(200));
    }

}
