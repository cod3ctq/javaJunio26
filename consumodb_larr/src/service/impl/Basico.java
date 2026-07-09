package service.impl;

import constants.Mensajes;
import dao.CuentaDAO;
import dao.MovimientoDAO;
import dto.CuentaDTO;
import entity.Movimiento;
import exception.*;
import models.Atm;
import models.Ticket;
import service.IOperacionesBasicas;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Basico extends Atm implements IOperacionesBasicas {

    // Inyeccion de dependencias (F!) : atributo
    private final MovimientoDAO movDAO = new MovimientoDAO();
    private final CuentaDAO cuentaDAO = new CuentaDAO();


    @Override
    public List<Object> cobrarRetiroSinTarjeta() throws InvalidReferenceException, AlreadyCollectedException {
        // Capturar solo la referencia, validarla

        Scanner scan = new Scanner(System.in);
        String referencia="";
        String clave ="";
        referencia = scan.nextLine();
        Ticket ticket = null;
        System.out.println("Captura la referencia - 16 digitos");

        List<Object> respuesta = new ArrayList<Object>();

        if(referencia.length() != 16){ // Valida longitud de referencia
//            System.out.println("Referenia Invalida");
            throw new InvalidReferenceException(Mensajes.INVALID_REFERENCE);
        }else if(getRetirosCobrados(). contains(referencia)){ // Validar si ya fue cobrada ...
//            System.out.println("Esta referencia ya fue cobrada !");
            throw new AlreadyCollectedException(Mensajes.ALREADY_PAIDED);
        }else { // Sino, entonces buscamos el retiro dentro del cache
            String numCuenta ="";
            double monto = 0.0;
            // Entonces buscamos el retiro dentro del cache
            for(String key : getCacheRetirosST().keySet()){
                if (key.split(":")[1].equals(referencia)){
                    numCuenta = key.split(":")[0];
                    monto = getCacheRetirosST().get(key);
                    break;
                }
            }

            // Marcar como cobrado este retiro (agregar al set)
            getRetirosCobrados().add(referencia);
            // Adquiere los datos de la cuenta de donde se tomará el dinero.
            CuentaDTO dto = buscarCuenta(numCuenta);
            // Descuenta el dinero de la cuenta
            cuentaDAO.actualizarSaldo(numCuenta, dto.getSaldo()-monto);
            // Registrar el movimiento
            movDAO.registrarMovimiento(new Movimiento(0, dto.getCuentaId(),"RETIRO", Date.valueOf(LocalDate.now()), monto));

            // Instancio el objeto models.Ticket
            ticket = new Ticket(this.getUbicacion(),LocalDate.now(), numCuenta, "RETIRO", monto, "RT"+(folioOperacion++));
            // Construye lista de salida
            respuesta.add(ticket);
            respuesta.add(monto);

        }
        return respuesta;
    }




    //------------------------------------------------------------------------------------------------------------------
    // Metodo para Retirar

    // Propagacion de excepciones : throw y throws
    // THROW : CREA LA EXCEPCION EN EL PUNTO NECESARIO DEL FLUJO, ¿Dónde colocas el throw? Dentro del metodo
    // THROWS : PROPAGA LA EXCEPCION, ¿Dónde colocas el throws? Se coloca en la firma o definicion del metodo

    @Override  // Momento 1
    public List<Object> retirar (CuentaDTO cuenta, double monto)
            throws AccountNotFoundException, WrongNipException, InsufficentBalanceException, UnderMinimumLimitException {

        // VALIDAR LIMITE DE MONTO ($$) DE RETIRO DIARIO ************************
        // VALIDAR LA CANTIDAD (SOLO MULTIPLOS DE 100)

        // Buscar la cuenta
        // validar el nip

        Ticket ti = null;
        List<Object> data = new ArrayList<>();

       if(monto > cuenta.getSaldo()){
            // validar que monto a retirar sea menor al saldo disponible
            throw new InsufficentBalanceException(Mensajes.INSUFFICENT_BALANCE);

            //System.out.println("Saldo insuficiente");
        }else if((cuenta.getSaldo()-monto) < cuenta.getSaldoMin()){
            throw new UnderMinimumLimitException(Mensajes.UNDER_MINIMUM_LIMIT);

            // validar que el saldo disponible - el monto sea > al saldo minimo de la cuenta
            //System.out.println("Retiro no disponible, limite inferior alcanzada");
        }else{
            // calcular el indice de donde tome el objeto original
            int index = getDbcuentas().indexOf(cuenta);
            // retirar (descontar el monto)
            cuenta.setSaldo(cuenta.getSaldo()-monto);
            // actualizar el saldo de la cuenta (la que está en la lista, reemplazando el objeto)
            getDbcuentas().set(index,cuenta);

            // Invocar el metodo (registrarMovimiento) que registra el movimiento (En la base de datos)
            movDAO.registrarMovimiento(new Movimiento(0, cuenta.getCuentaId(),
                    "RETIRO", Date.valueOf(LocalDate.now()),monto));


            // Invocar al metodo que actualiza los saldos en las cuentas (En la base de datos)
            cuentaDAO.actualizarSaldo(cuenta.getNumCuenta(), cuenta.getSaldo());


            // generar el ticket
//            int fo = folioOperacion ++;
            ti = new Ticket(this.getUbicacion(), LocalDate.now(),cuenta.getNumCuenta(),
                    "RETIRO",monto,"RT"+(folioOperacion++));
            // añade los elementos resultantes a la lista de salida
            data.add(ti);
            data.add(monto);
        }
        // Retornar resultados
        return data;

    }


}
