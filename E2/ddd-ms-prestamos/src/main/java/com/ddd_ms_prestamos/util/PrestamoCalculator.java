package com.ddd_ms_prestamos.util;

import com.ddd_ms_persistence.entity.Cuenta;
import com.ddd_ms_persistence.entity.TipoPrestamo;
import com.ddd_ms_prestamos.contastants.Mensaje;
import com.ddd_ms_prestamos.exception.BusinessException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class PrestamoCalculator {


    //Este metodo valida la posibilidad de realizar el prestamo
    //basado en el monto, el tipo de prestamo y el saldo actual de la cuenta

    public static List<Object> validarPrestamo(Cuenta cuenta, TipoPrestamo tipo, double monto){

        boolean aprobado = false;
        List<Object> data= new ArrayList<Object>();
        //1500c+ 0.09
        double cantidadAPrestar = monto + (monto * (tipo.getInteres() / 100.00));
        System.out.println(cantidadAPrestar +"<= "+(cuenta.getSaldo() * 0.60));
        if (cantidadAPrestar <= (cuenta.getSaldo() * 0.60)) {
            aprobado = true;
            data.add(aprobado);
            data.add(cantidadAPrestar);
            return data;
        }else{
            throw new BusinessException(Mensaje.DENIED);
        }

    }





}
