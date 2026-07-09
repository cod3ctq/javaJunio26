package com.ms_tipo_cuenta.controller;

import com.ms_tipo_cuenta.dto.tipoCuentaRequest;
import com.ms_tipo_cuenta.entity.tipoCuenta;
import com.ms_tipo_cuenta.logic.tipoCuentaLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//http://localhost:8091/api/v1/tipoCuenta
@RestController
@RequestMapping("/api/v1/tipoCuenta")
public class TipoCuentaController {

@Autowired
    tipoCuentaLogic type;

@GetMapping
    public ResponseEntity <List<tipoCuenta>> mostrar(){
    List<tipoCuenta> cuentas = type.mostrar();
    return new ResponseEntity<List<tipoCuenta>>(cuentas, HttpStatus.valueOf(200));
}
@PostMapping
    public ResponseEntity <tipoCuenta> guardar (@RequestBody tipoCuentaRequest request){
    tipoCuenta tipo = type.guardar(request);
    return new ResponseEntity<tipoCuenta>(tipo, HttpStatus.valueOf(200));
}
@PutMapping
    public ResponseEntity <tipoCuenta> actulizar (@RequestBody tipoCuentaRequest request){
    tipoCuenta tipo = type.actualizar(request);
    return new ResponseEntity<tipoCuenta>(tipo, HttpStatus.valueOf(200));
}
@GetMapping("/buscar/{id}")
    public ResponseEntity<tipoCuenta> buscar(@PathVariable int id){
    tipoCuenta tipo = type.buscar(id);
    return new ResponseEntity<tipoCuenta>(tipo, HttpStatus.valueOf(200));
}
@DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminar(@PathVariable int id){
    String mensaje = type.eliminar(id);
    return new ResponseEntity<String>(mensaje, HttpStatus.valueOf(200));
}


}
