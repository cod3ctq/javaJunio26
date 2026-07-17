package com.ms_prestamos.controller;

import com.ms_prestamos.dto.PrestamoRequest;
import com.ms_prestamos.dto.PrestamoResponse;
import com.ms_prestamos.entity.Prestamos;
import com.ms_prestamos.logic.PrestamoLogic;
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
    public ResponseEntity<List<Prestamos>> mostrar(){
        List<Prestamos> prestamos = prestamo.mostrar();
        return new ResponseEntity<List<Prestamos>>(prestamos, HttpStatusCode.valueOf(200));
    }

    @PostMapping
    public ResponseEntity<Prestamos> guardar(@RequestBody PrestamoRequest request){
        Prestamos prestamos = prestamo.guardar(request);
        return new ResponseEntity<Prestamos>(prestamos, HttpStatusCode.valueOf(200));
    }

    //Se borro el metod actualiar por regla de negocio no es requerido
    // actualizar los datos de un prestamo una vez que se concretado

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Prestamos> buscar(@PathVariable int id){
        PrestamoResponse prestamos = prestamo.buscar(id);
        return new ResponseEntity<Prestamos>(prestamos, HttpStatusCode.valueOf(200));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable int id){
        String mensaje = prestamo.eliminar(id);
        return new ResponseEntity<String>(mensaje, HttpStatusCode.valueOf(200));
    }
    //Borrado logico
    @DeleteMapping Mapping("/{id}")
    public ResponseEntity<String> desactiavr(@PathVariable int id){
        String mensaje = prestamo.desactivarPrestamo(id);
        return new ResponseEntity<String>(mensaje, HttpStatusCode.valueOf(200));
    }


}
