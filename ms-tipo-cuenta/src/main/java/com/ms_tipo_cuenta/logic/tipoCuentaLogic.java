package com.ms_tipo_cuenta.logic;

import com.ms_tipo_cuenta.dto.tipoCuentaRequest;
import com.ms_tipo_cuenta.entity.tipoCuenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ms_tipo_cuenta.repository.tipoCuentaRepository;
import com.ms_tipo_cuenta.service.tipoCuentaService;

import java.util.List;

@Service
public class tipoCuentaLogic implements tipoCuentaService {

    @Autowired
    tipoCuentaRepository repo;

    @Override
    public List mostrar() {
        return repo.findAll();
    }

    @Override
    public tipoCuenta guardar(tipoCuentaRequest request) {
        tipoCuenta tc = new tipoCuenta();
        tc.setDescripcion(request.getDescripcion());
        tc.setSaldoMin(request.getSaldoMinimo());
        tc.setSaldoMax(request.getSaldoMaximo());

        repo.save(tc);
        return tc;
    }

    @Override
    public tipoCuenta actualizar(tipoCuentaRequest request) {
        tipoCuenta tc = repo.findById(request.getTipoCuentaId()).get();
        tc.setDescripcion(request.getDescripcion());
        tc.setSaldoMin(request.getSaldoMinimo());
        tc.setSaldoMax(request.getSaldoMaximo());
        repo.save(tc);
        return tc;
    }

    @Override
    public tipoCuenta buscar(int id) {
        return repo.findById(id).get();
    }

    @Override
    public String eliminar(int id) {
        repo.deleteById(id);
        return "Eliminado";
    }
}
