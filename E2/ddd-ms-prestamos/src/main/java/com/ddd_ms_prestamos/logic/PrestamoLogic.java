package com.ddd_ms_prestamos.logic;

import com.ddd_ms_persistence.entity.Cuenta;
import com.ddd_ms_persistence.entity.Prestamo;
import com.ddd_ms_persistence.entity.TipoPrestamo;
import com.ddd_ms_persistence.repository.CuentaRepository;
import com.ddd_ms_persistence.repository.PrestamoRepository;
import com.ddd_ms_persistence.repository.TipoPrestamoRepository;
import com.ddd_ms_prestamos.contastants.Mensaje;
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

    private final CuentaRepository cuentaRepo;
    private final TipoPrestamoRepository tpRepo;

    @Autowired
    public PrestamoLogic(CuentaRepository cuentaRepo, TipoPrestamoRepository tpRepo) {
        this.cuentaRepo = cuentaRepo;
        this.tpRepo = tpRepo;
    }
    @Autowired
    PrestamoRepository presRepo;

    @Override
    public PrestamoResponse calculaPrestamo(PrestamoRequest request) {
        Optional<Cuenta> envCuenta = cuentaRepo.findByClienteId(request.clienteId());
        Optional<TipoPrestamo> envTipo= tpRepo.findById(request.tipoPrestamoId());

        //System.out.println("<<<<<<<<<<<<<<<<<<<<<<"+(boolean)PrestamoCalculator.validarPrestamo(envCuenta.get(),envTipo.get(),request.monto()).get(0));
        if(envCuenta.isEmpty()){
            //System.out.println("no se pudo validar el prestamo");
            throw  new NotFoundException(Mensaje.ACCOUNT_NOT_FOUND);
        }else if (envTipo.isEmpty()){
           // System.out.println("no se pudo validar el prestamo no exite el tipo de prestamo");
            throw new NotFoundException(Mensaje.TYPE_NOT_FOUND);
        }else if ((boolean)PrestamoCalculator.validarPrestamo(envCuenta.get(),envTipo.get(),request.monto()).get(0)){
           // PrestamoResponse response = new PrestamoResponse();
           return PrestamoMapper.ToResponse(envCuenta.get(),envTipo.get(),request.monto(),"APROBADO");
        }else{
           // System.out.println("prestamo no autorizado");
            throw new BusinessException(Mensaje.DENIED);
        }
    }

    @Override
    public PrestamoResponse registrarPrestamo(PrestamoRequest request) {

        Optional<Cuenta> envCuenta = cuentaRepo.findByClienteId(request.clienteId());
        Optional<TipoPrestamo> envTipo= tpRepo.findById(request.tipoPrestamoId());
        List<Object> datos=  PrestamoCalculator.validarPrestamo(envCuenta.get(),envTipo.get(),request.monto());


        //System.out.println("<<<<<<<<<<<<<<<<<<<<<<"+(boolean)PrestamoCalculator.validarPrestamo(envCuenta.get(),envTipo.get(),request.monto()).get(0));
        if(envCuenta.isEmpty()){
            //System.out.println("no se pudo validar el prestamo");
            throw  new NotFoundException(Mensaje.ACCOUNT_NOT_FOUND);
        }else if (envTipo.isEmpty()){
            // System.out.println("no se pudo validar el prestamo no exite el tipo de prestamo");
            throw new NotFoundException(Mensaje.TYPE_NOT_FOUND);
        }else if ((boolean)datos.get(0)){

            Prestamo prestamo = PrestamoMapper.ToEntity(
                    request.clienteId(),
                    request.tipoPrestamoId(),
                    request.monto(),
                    envTipo.get().getPlazo(),
                    (double) datos.get(1));
            presRepo.save(prestamo);
            return PrestamoMapper.ToResponse(envCuenta.get(),envTipo.get(), request.monto(),"REGISTRADO");
        }else{
            // System.out.println("prestamo no autorizado");
            throw new BusinessException(Mensaje.DENIED);
        }
    }
}
