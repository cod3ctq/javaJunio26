package service.impl;

import constants.Mensajes;
import dao.CuentaDAO;
import dao.MovimientoDAO;
import dto.CuentaDTO;
import entity.Movimiento;
import exception.*;
import models.ATM;
import models.Ticket;
import service.IOperacionesBasicas;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Basico extends ATM implements IOperacionesBasicas {

    //Inyeccion de dependencias (F1): atributo
    private final MovimientoDAO movDAO = new MovimientoDAO();
    private final CuentaDAO cuentaDAO = new CuentaDAO();

    @Override
    public List<Object> cicobrarRetirosSinTarjeta() throws InvalidSecurityKeyException, AlreadyPaidedException {
        //Capturar solo la referencia y validarla
        Scanner sc = new Scanner(System.in);
        String referencia = "";
        System.out.println("Cptura la referencia - 16 Digitos");
        referencia = sc.nextLine();
        Ticket ticket = null;
        List<Object>respuesta = new ArrayList<Object>();

        if(referencia.length()!=16){
            throw new InvalidReferenceException(Mensajes.INVALID_REFERENCE);
        }else if(getRetirosCobrados().contains(referencia)){
            throw new AlreadyPaidedException(Mensajes.ALREADY_PAIDED);
        }else {
            String numCuenta="";
            double monto=0.0;
            for(String key : getCacheRetirosST().keySet()){
                if(key.split(":")[1].equals(referencia)) {
                    numCuenta = key.split(":")[0];
                    monto = getCacheRetirosST().get(key);
                    break;
                }
            }
            //Marcar como cobrado el recibo
            getRetirosCobrados().add(referencia);
            //Adquiere los datos de la cuenta donde se tomara el dinero
            CuentaDTO dto = buscarCuenta(numCuenta);
            //descuenta el dinero de la cuenta
            cuentaDAO.actualizarSaldo(numCuenta,dto.getSaldo()-monto);
            //registra el movimiento
            movDAO.registrarMovimiento(new Movimiento(0,dto.getCuentaId(),"RETIRO",
                    Date.valueOf(LocalDate.now()),monto));
            //Instancio el objeto ticket
            ticket = new Ticket(this.getUbicacion(), LocalDate.now(),numCuenta,"RETIRO",monto,
                    "RT"+(folioOperacion++));
            //construye lista de salida
            respuesta.add(ticket);
            respuesta.add(monto);
        }
        return respuesta;
    }

    //Programacion de excepciones: throw y throws
    //throw : crea la excepcion en el punto necesario del flujo, se coloca dentro del metodo
    //throws : propaga la excepcion, se coloca en la firma o definicion del metodo
    @Override//Momento 1
    public List<Object>retirar(CuentaDTO cuenta, double monto)
            throws AccountNotFoundException, WrongNipException, InsufficentBalanceException, UnderMinimunLimit {
        ///***VALIDAR LIMITE DE MONTO ($$$) DE RETIRO DIARIO***
        ///***VALIDAR LA CANTIDAD (MULTIMPOS DE 100)***


        Ticket t1 = null;
        List<Object> data = new ArrayList<>();
        // si la cuenta no existe
       if (monto> cuenta.getSaldo()) {
            throw new InsufficentBalanceException(Mensajes.INSUFFICENT0_BALANCE);
            //validar que monto a retirar sea menor al saldo disponible
            //System.out.println("Saldo insuficiente");
        } else if ( (cuenta.getSaldo()- monto ) < cuenta.getSaldomin()) {
            throw new UnderMinimunLimit(Mensajes.UNDER_MINIMUM_LIMIT);
            //validar que (saldo disponible - monto) > saldo minimo de la cuenta
            //System.out.println("Retiro no disponible, limite inferiror alcanzado");
        }else {
            int index = getDbcuentas().indexOf(cuenta);
            //retirar el monto
            cuenta.setSaldo(cuenta.getSaldo() - monto);

            getDbcuentas().set(index,cuenta);

            ///Invocar al metodo que registra el movimiento
            movDAO.registrarMovimiento(new Movimiento(0, cuenta.getCuentaId(),
                    "RETIRO", Date.valueOf(LocalDate.now()),monto));

            //Invocar al metodo que actualiza los saldos de las cuentas

            cuentaDAO.actualizarSaldo(cuenta.getNumCuenta(),cuenta.getSaldo());


            //generar ticket
            t1=new Ticket(this.getUbicacion(), LocalDate.now(),
                    cuenta.getNumCuenta(),"RETIRO",monto,"RT"+(folioOperacion++));

            data.add(t1);
            data.add(monto);
        }
        return data;
    }
}
