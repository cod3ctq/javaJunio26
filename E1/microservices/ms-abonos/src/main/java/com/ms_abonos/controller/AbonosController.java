package com.ms_abonos.controller;

import com.ms_abonos.dto.AbonoRequest;
import com.ms_abonos.entity.Abono;
import com.ms_abonos.logic.AbonoLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/abonos")
public class AbonosController {
    @Autowired
    AbonoLogic service;


    @GetMapping
    public ResponseEntity<List<Abono>> mostrar(){
        List<Abono> abonos = service.mostrar();
        return new ResponseEntity<List<Abono>>(abonos, HttpStatusCode.valueOf(200));
    }

    @PostMapping
    public ResponseEntity<Abono> guardar(@RequestBody AbonoRequest request){
        Abono abono = service.guardar(request);
        return new ResponseEntity<Abono>(abono, HttpStatusCode.valueOf(200));
    }

    @PutMapping
    public ResponseEntity<Abono> actualizar(@RequestBody AbonoRequest request){
        Abono abono = service.actualizar(request);
        return new ResponseEntity<Abono>(abono, HttpStatusCode.valueOf(200));
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Abono> buscar(@PathVariable int id){
        Abono abono = service.buscar(id);
        return new ResponseEntity<Abono>(abono, HttpStatusCode.valueOf(200));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable int id){
        String mensaje = service.eliminar(id);
        return new ResponseEntity<String>(mensaje, HttpStatusCode.valueOf(200));
    }
}
