package com.ms_tipo_tarjeta.contrller;

import com.ms_tipo_tarjeta.dto.TipoTarjetaRequest;
import com.ms_tipo_tarjeta.entity.TipoTarjeta;
import com.ms_tipo_tarjeta.logic.TipoTarjetaLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("api/v1/tipotarjeta")
public class TipoTarjetaController {


    @Autowired
    TipoTarjetaLogic service;



    @GetMapping
    public ResponseEntity<List<TipoTarjeta>> mostrar() {
        List<TipoTarjeta> servicios = service.mostrar();
        return new ResponseEntity<List<TipoTarjeta>>(servicios, HttpStatusCode.valueOf(200));
    }

    @PostMapping
    public ResponseEntity<TipoTarjeta> guardar(@RequestBody TipoTarjetaRequest request) {
        TipoTarjeta servicio = service.guarder(request);
        return new ResponseEntity<TipoTarjeta>(servicio, HttpStatusCode.valueOf(200));
    }
    // @RequestBody  : habilita la manipulacion del cuerpo de la peticion

    @PutMapping
    public ResponseEntity<TipoTarjeta> actualizar(@RequestBody TipoTarjetaRequest request) {
        TipoTarjeta servicio = service.actualizar(request);
        return new ResponseEntity<TipoTarjeta>(servicio, HttpStatusCode.valueOf(200));
    }
    // permite extraer los valores passados como variables en las urls
    @GetMapping("/buscar/{id}")
    public ResponseEntity<TipoTarjeta> buscar(@PathVariable int id) {
        TipoTarjeta servicio = service.buscar(id);
        return new ResponseEntity<TipoTarjeta>(servicio, HttpStatusCode.valueOf(200));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable int id) {
        String mensaje = service.eliminar(id);
        return new ResponseEntity<String>(mensaje, HttpStatusCode.valueOf(200));
    }




}
