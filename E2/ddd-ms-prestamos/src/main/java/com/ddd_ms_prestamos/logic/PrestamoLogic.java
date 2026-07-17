package com.ddd_ms_prestamos.logic;

import com.ddd_ms_persistence.entity.Cuenta;
import com.ddd_ms_persistence.entity.Prestamo;
import com.ddd_ms_persistence.entity.TipoPrestamo;
import com.ddd_ms_persistence.repository.CuentaRepository;
import com.ddd_ms_persistence.repository.PrestamoRepository;
import com.ddd_ms_persistence.repository.TipoPrestamoRepository;
import com.ddd_ms_prestamos.constants.Mensajes;
import com.ddd_ms_prestamos.dto.PrestamoRequest;
import com.ddd_ms_prestamos.dto.PrestamoResponse;
import com.ddd_ms_prestamos.exception.BussinesException;
import com.ddd_ms_prestamos.service.PrestamoService;
import com.ddd_ms_prestamos.util.PrestamoCalculator;
import jakarta.ws.rs.NotFoundException;
import mapper.PrestamoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PrestamoLogic implements PrestamoService {

    //Implementar aqui la inyeccion de los repositorys
    //toda la adquisicion de datos de estos 2 primeros casos de uso
    //se hara mediante repositorys
    @Autowired
    CuentaRepository cuentaRepo;
    @Autowired
    TipoPrestamoRepository tpRepo;

    @Autowired
    PrestamoRepository presRepo;

    @Override
    public PrestamoResponse calculaPrestamo(PrestamoRequest request) {
        Optional<Cuenta> envcuenta = cuentaRepo.findByClienteId(request.clienteId());
        Optional<TipoPrestamo> envTipo = tpRepo.findById(request.tipoPrestamoId());
        if (envcuenta.isEmpty()) {
            throw new NotFoundException(Mensajes.ACCOUNT_NOT_FOUND);
        } else if (envTipo.isEmpty()) {
            throw new NotFoundException(Mensajes.TYPE_NOT_FOUND);
        } else if ((boolean) PrestamoCalculator.validarPrestamo(envcuenta.get(),
                envTipo.get(), request.monto()).get(0)) {
            return PrestamoMapper.toResponse(envcuenta.get(), envTipo.get(), request.monto(), "APROBADO");
        } else {
            throw new BussinesException(Mensajes.DENIED);
        }
    }

    @Override
    public PrestamoResponse registrarPrestamo(PrestamoRequest request) {
        Optional<Cuenta> envcuenta = cuentaRepo.findByClienteId(request.clienteId());
        Optional<TipoPrestamo> envTipo = tpRepo.findById(request.tipoPrestamoId());
        List<Object>datos = PrestamoCalculator.validarPrestamo(envcuenta.get(), envTipo.get(), request.monto());
        if (envcuenta.isEmpty()) {
            throw new NotFoundException(Mensajes.ACCOUNT_NOT_FOUND);
        } else if (envTipo.isEmpty()) {
            throw new NotFoundException(Mensajes.TYPE_NOT_FOUND);
        } else if ((boolean)datos.get(0)) {
            //creacion de la entidad
            Prestamo prestamo = PrestamoMapper.toEntity(request.clienteId(), request.tipoPrestamoId(), request.monto(),
                    envTipo.get().getPlazo(),(double)datos.get(1));
            //Persistencia
            presRepo.save(prestamo);
            return PrestamoMapper.toResponse(envcuenta.get(), envTipo.get(), request.monto(), "REGISTRADO");
        } else {
            throw new BussinesException(Mensajes.DENIED);
        }
    }
}
