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
import com.ddd_ms_prestamos.exception.BusinessException;
import com.ddd_ms_prestamos.exception.NotFoundException;
import com.ddd_ms_prestamos.mapper.PrestamoMapper;
import com.ddd_ms_prestamos.service.PrestamoService;
import com.ddd_ms_prestamos.util.PrestamoCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrestamoLogic implements PrestamoService {

    //Implementar aqui la inyeccion de los repositorys
    //toda la adquisicion de datos de estos 2 primeros casos de uso
    //se hara mediante repositorys
    @Autowired
    CuentaRepository CuentaRepo;

    @Autowired
    TipoPrestamoRepository tpRepo;

    @Autowired
    PrestamoRepository presRepo;


    @Override
    public PrestamoResponse calculaPrestamo(PrestamoRequest request) {
        Optional<Cuenta> envCuenta = CuentaRepo.findByClienteId(request.clienteId());
        Optional<TipoPrestamo> envTipo = tpRepo.findById(request.tipoPrestamoId());
        if(envCuenta.isEmpty()){
            throw new NotFoundException(Mensajes.ACCOUNT_NOT_FOUND);
//            System.out.println("No se puedo validar el prestamo. La cuenta no existe");
        } else if (envTipo.isEmpty()) {
            throw new NotFoundException(Mensajes.ACCOUNT_NOT_FOUND);
//            System.out.println("No se pudo validar el prestamo. El tipo prestamo no existe");
        } else if((boolean) (PrestamoCalculator.validarPrestamo(envCuenta.get(), envTipo.get(), request.monto()).get(0))){
            return PrestamoMapper.toResponse(envCuenta.get(), envTipo.get(), request.monto(),"APROBADO");
        } else {
            throw new BusinessException(Mensajes.DENIED);
//            System.out.println("Prestamo no autorizado");
        }
    }

    @Override
    public PrestamoResponse registrarPrestamo(PrestamoRequest request) {
        Optional<Cuenta> envCuenta = CuentaRepo.findByClienteId(request.clienteId());
        Optional<TipoPrestamo> envTipo = tpRepo.findById(request.tipoPrestamoId());
        List<Object> datos = PrestamoCalculator.validarPrestamo(envCuenta.get(), envTipo.get(), request.monto());
        if(envCuenta.isEmpty()){
            throw new NotFoundException(Mensajes.ACCOUNT_NOT_FOUND);
//            System.out.println("No se puedo validar el prestamo. La cuenta no existe");
        } else if (envTipo.isEmpty()) {
            throw new NotFoundException(Mensajes.ACCOUNT_NOT_FOUND);
//            System.out.println("No se pudo validar el prestamo. El tipo prestamo no existe");
        } else if((boolean)(datos.get(0))){
            //Creacion de la entidad
            Prestamo prestamo = PrestamoMapper.toEntity(request.clienteId(), request.tipoPrestamoId(), request.monto(),envTipo.get().getPlazo(),(double)datos.get(1));
            //persistencia
            presRepo.save(prestamo);

            return PrestamoMapper.toResponse(envCuenta.get(), envTipo.get(), request.monto(),"REGISTRADO");
        } else {
            throw new BusinessException(Mensajes.DENIED);
//            System.out.println("Prestamo no autorizado");
        }
    }
}
