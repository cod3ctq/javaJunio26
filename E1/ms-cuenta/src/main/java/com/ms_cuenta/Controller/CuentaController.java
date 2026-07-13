package com.ms_cuenta.Controller;


import com.ms_cuenta.dto.CuentaRequest;
import com.ms_cuenta.entity.Cuenta;
import com.ms_cuenta.logic.CuentaLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 6) En la capa 6 se establecen las rutas (endpoint) junto con los verbos de accion que le dicen al servidor que accion ejecutar
Es la creacion del contrato de funcionalidad que el servidor expone para ser consumido por los clientes
*/
//mexico/aguascalientes/aguascalientes/12345/
//{------------- URL ------------------}
//                             {endpoint}
//http://localhost:8090/api/v1/servicios
@RestController
@RequestMapping("api/v1/cuentas") //Path a nivel controller
public class CuentaController {
    @Autowired
    //clase - objeto
    CuentaLogic service;
    // los verbos de accion refleja la intencion de la accion

    @GetMapping
    public ResponseEntity<List<Cuenta>> mostrar() {
        List<Cuenta> cuenta = service.mostrar();
        return new ResponseEntity<List<Cuenta>>(cuenta, HttpStatusCode.valueOf(200));
    }
    // @RequestBody:Habilita la  manipulacion del cuerpo de la peticion
    @PostMapping // para agregar
    public ResponseEntity<Cuenta> guardar(@RequestBody CuentaRequest request) {
        Cuenta cuenta = service.guardar(request);
        return new ResponseEntity<Cuenta>(cuenta, HttpStatusCode.valueOf(200));
    }

    @PutMapping // para editar
    public ResponseEntity<Cuenta> actualizar(@RequestBody CuentaRequest request) {
        Cuenta cuenta = service.actualizar(request);
        return new ResponseEntity<Cuenta>(cuenta, HttpStatusCode.valueOf(200));
    }

    //path varible: permite extraer los valores pasados como variables en las urls
    @GetMapping("/buscar/{id}") // {parametro}  va sin llaves
    public ResponseEntity<Cuenta> buscar(@PathVariable int id) {
        Cuenta cuenta = service.buscar(id);
        return new ResponseEntity<Cuenta>(cuenta, HttpStatusCode.valueOf(200));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable int id) {
        String mensaje = service.eliminar(id);
        return new ResponseEntity<String>(mensaje, HttpStatusCode.valueOf(200));
    }
}
