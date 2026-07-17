package com.ddd_ms_prestamos.util;

import com.ddd_ms_persistence.entity.Cuenta;
import com.ddd_ms_persistence.entity.TipoPrestamo;

import java.util.ArrayList;
import java.util.List;

public class PrestamoCalculator {


    //Este metodo valida la posibilidad de realizar el prestamo
    //basado en el monto, el tipo de prestamo y el saldo actual de la cuenta

    public static List<Object> validarPrestamo(Cuenta cuenta, TipoPrestamo tipo, double monto){
        boolean aprobado = false;
        List<Object> data = new ArrayList<Object>();
        //                        15000 +  (15000 * ( 9 / 100 ) )
        double cantidadAPrestar = monto + (monto * (tipo.getInteres()/100.00));
        if (cantidadAPrestar <= (cuenta.getSaldo() * 0.60)) {
            aprobado = true;
            data.add(aprobado); // 0
            data.add(cantidadAPrestar); // 1
        }
        return data;
    }





}
