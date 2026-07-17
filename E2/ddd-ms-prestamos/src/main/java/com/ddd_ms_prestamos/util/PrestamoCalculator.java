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
        //                        15000 +( 15000 * (0.9))=
        System.out.println("----saldo : "+cuenta.getSaldo());
        System.out.println("----interes : "+tipo.getInteres()/100.00);
        double cantidadAPrestar = monto + (monto * (tipo.getInteres() / 100.00));
        System.out.println(">>>>>>>>>>>>>>>:" +cantidadAPrestar);
        if (cantidadAPrestar <= (cuenta.getSaldo() * 0.60)) {
            aprobado = true;
            data.add(aprobado);
            data.add(cantidadAPrestar);
            System.out.println("$$$$$$$$$$$ : "+data);
        }
        return data;
    }





}
