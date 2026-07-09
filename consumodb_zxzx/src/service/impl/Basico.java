package service.impl;

import constants.Mensajes;
import dao.MovimientoDAO;
import dto.CuentaDTO;
import entity.Movimiento;
import exception.AlreadyCollectedException;
import exception.InsufficentBalanceException;
import exception.InvalidReferenceException;
import exception.UnderMinimunLimitException;
import models.Atm;
import models.Ticket;
import service.IOperacionesBasicas;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Basico extends Atm implements IOperacionesBasicas {

    //Inyeccion de dependencias (F1) : atributo
    private final MovimientoDAO movDAO = new MovimientoDAO();

    @Override
    public List<Object> cobrarRetiroSinTarjeta() throws InvalidReferenceException, AlreadyCollectedException {
        //Capturar solo la referencia, validarla
        Scanner scan = new Scanner(System.in);
        String referencia="";
        Ticket ticket = null;
        List<Object> respuesta = new ArrayList<Object>();

        System.out.println("Captura la referencia - 16 digitos");
        referencia = scan.nextLine();

        if(referencia.length()!=16){ //Valida longitud de referencia
            //System.out.println("Referencia Invalida");
            throw new InvalidReferenceException(Mensajes.INVALID_REFERENCE);
        }else if(getRetirosCobrados().contains(referencia)){ //validar si ya fue cobrada ....
            //System.out.println("Esta referencia ya fue cobrada !");
            throw new AlreadyCollectedException(Mensajes.ALREADY_PAIDED);
        }else{ //sino
            String numCuenta="";
            double monto =0.0;
            //entonces buscamos el retiro dentro del caché
            for(String key : getCacheRetirosST().keySet()){
                if (key.split(":")[1].equals(referencia)) {
                    numCuenta = key.split(":")[0];
                    monto = getCacheRetirosST().get(key);
                    break;
                }
            }
            //marcar como cobrado este retiro (agregar al set)
            getRetirosCobrados().add(referencia);
            //Adquiere los datos de la cuenta de donde se tomara el dinero
            CuentaDTO dto = buscarCuenta(numCuenta);
            //descuenta el dinero de la cuenta
            cuentaDAO.actualizarSaldo(numCuenta,dto.getSaldo()-monto);
            //registra el movimiento
            movDAO.registrarMovimiento(new Movimiento(0,dto.getCuentaId(),
                    "RETIRO",Date.valueOf(LocalDate.now()), monto));
            //instancio el objeto ticket
            ticket = new Ticket(this.getUbicacion(), LocalDate.now(),numCuenta,"RETIRO",monto,
                    "RT"+(folioOperacion++));
            //construye lista de salida
            respuesta.add(ticket);
            respuesta.add(monto);
        }
        return respuesta;
    }
    // propagacion de excepciones : throw y throws
    // throw : crea la excepcion en el punto necesario del flujo, se coloca dentro del metodo
    // throws : propaga la excepcion, se coloca en la firma o definicion del metodo
    @Override    //momento 1
    public List<Object> retirar(CuentaDTO cuenta, double monto)
            throws InsufficentBalanceException, UnderMinimunLimitException {
        //Validar limite de monto ($$$) de retiro diario *****
        //Validar la cantidad (solo multiplos de 100)
        Ticket ti = null;
        List<Object> data = new ArrayList<>();
        //si la no cuenta existe
        if(monto > cuenta.getSaldo()){
            //validar que monto a retirar sea menor al saldo disponible
            throw new InsufficentBalanceException(Mensajes.INSUFFICIENT_BALANCE);
            //System.out.println("Saldo insuficiente");
        }else if( (cuenta.getSaldo() - monto) < cuenta.getSaldoMin()){
            //validar que (saldo disponible - monto) > saldo minimo de la cuenta
            throw new UnderMinimunLimitException(Mensajes.UNDER_MINIMUM_LIMIT);
            //System.out.println("Retiro no disponible, limite inferior alcanzado");
        }else{
            //calcular el indice de donde tome el objeto original
            int index = getDbcuentas().indexOf(cuenta);
            //retirar (descontar el monto)
            cuenta.setSaldo(cuenta.getSaldo() - monto);
            //actualizar el saldo de la cuenta (la que esta en la lista, reemplazando al objeto)
            getDbcuentas().set(index, cuenta);
            //invoca al metodo que registra el movimiento (en la base de datos)
            movDAO.registrarMovimiento(new Movimiento(0, cuenta.getCuentaId(),
                    "RETIRO", Date.valueOf(LocalDate.now()),monto));
            //invocar al metodo que actualiza los saldos de las cuentas (en la base de datos)
            cuentaDAO.actualizarSaldo(cuenta.getNumCuenta(), cuenta.getSaldo());
            //generar el ticket
            ti = new Ticket(this.getUbicacion(), LocalDate.now(),
                    cuenta.getNumCuenta(),"RETIRO",monto, "RT"+ (folioOperacion++));
            //añade los elementos resultantes a la lista de salida
            data.add(ti);
            data.add(monto);
        }
        //retornar resultados
        return data;
    }

}
