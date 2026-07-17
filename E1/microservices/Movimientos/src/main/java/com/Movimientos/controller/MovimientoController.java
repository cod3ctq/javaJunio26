package com.Movimientos.controller;

import com.Movimientos.dto.MovimientoRequest;
import com.Movimientos.entity.Movimiento;
import com.Movimientos.service.MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/Movimientos")
public class MovimientoController {
    @Autowired
    MovimientoService service;

    @GetMapping
    public ResponseEntity<List<Movimiento>> mostrar(){
        List servicios= service.mostrar();
        return  new ResponseEntity<List<Movimiento>>(servicios, HttpStatusCode.valueOf(200));
    }

    //@RequestBody: habilita la maipulacion dek cuerpo de la peticion
    @PostMapping
    public ResponseEntity<Movimiento> guardar(@RequestBody MovimientoRequest request){
        Movimiento servicio = service.guardar(request);
        return new ResponseEntity<>(servicio,HttpStatusCode.valueOf(200));
    }

    @PutMapping
    public ResponseEntity<Movimiento> actualizar(@RequestBody MovimientoRequest request){
        Movimiento servicio = service.actualizar(request);
        return  new ResponseEntity<Movimiento>(servicio,HttpStatusCode.valueOf(200));
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Movimiento> buscar(@PathVariable int id){
        Movimiento servicio = service.buscar(id);

        return new ResponseEntity<Movimiento>(servicio,HttpStatusCode.valueOf(200));
    }

    @DeleteMapping("eliminar/{id}")
    public ResponseEntity<String> eliminar(@PathVariable int id){
        String mensaje = service.eliminar(id);
        return new ResponseEntity<String>(mensaje,HttpStatusCode.valueOf(200));
    }
}
