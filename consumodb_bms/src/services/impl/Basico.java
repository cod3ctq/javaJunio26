package services.impl;

import constance.Mensajes;
import dao.CuentaDAO;
import dao.MovimientosDAO;
import dto.CuentaDTO;
import entity.Movimiento;
import exception.*;
import models.Atm;
import models.Ticket;
import services.IOperacionesBasicas;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Basico extends Atm implements IOperacionesBasicas {

    //Inyeccion de dependencias (F1) : atributos
    private final MovimientosDAO movDAO = new MovimientosDAO();
    private final CuentaDAO cuentaDAO = new CuentaDAO();

    @Override
    public List<Object> cobrarRetiroSinTarjeta() throws InvalidReferenceException, AlreadyCollectedException {
        //Capturar solo la referencia, validarla
        Scanner sc = new Scanner(System.in);
        String referencia ="";
        System.out.println("Captura la referencia -16 digitos");
        referencia = sc.nextLine();
        Ticket ticket = null;
        List<Object> respuesta = new ArrayList<Object>();

        if(referencia.length()!=16){//Valida longitud de referencia
//            System.out.println("Referencia Invalida");
            throw new InvalidReferenceException(Mensajes.INVALID_REFERENCE);
        } else if (Atm.getRetirosCobrados().contains(referencia)) {//validar si la fue cobrado
//            System.out.println("Esta referencia ya fue cobrada");
            throw new AlreadyCollectedException(Mensajes.ALREADY_PAIDED);
        } else{ //si no, entonces buscamos a los
            String numCuenta = "";
            double monto = 0.0;
            //entonces buscamos el retiro dentro del cache
            for(String key : Atm.getCacheRetirosST().keySet()){
                if (key.split(":")[1].equals(referencia)) {
                    numCuenta = key.split(":")[0];
                    monto = Atm.getCacheRetirosST().get(key);
                    break;
                }

            }
            //marcar como cobrado este retir(agregar al set)
            Atm.getRetirosCobrados().add(referencia);
            CuentaDTO dto = Atm.buscarCuenta(numCuenta);
            cuentaDAO.actualizarSaldo(numCuenta,dto.getSaldo()-monto);
            movDAO.registrarMovimiento(new Movimiento(0,dto.getCuentaId(),"RETIRO", Date.valueOf(LocalDate.now()),monto));
            //instancia el objeto ticket
            ticket = new Ticket(this.getUbicacion(),LocalDate.now(),numCuenta,"RETIRO",monto,"RT"+(Atm.folioOperacion++));
            //construye lista de salida
            respuesta.add(ticket);
            respuesta.add(monto);
        }
        return respuesta;

        //perdiente resolver:
        //Como traer un objeto cuentaDTO a fin de extraer aqui: cuentaId y saldo actual de la cyenta
        //para actualizar el saldo y registrar el movimiento
    }

    //Propagacion de exceptions : throw y throws
    //throw : Crea la exception en el punto necesario del flujo, se coloca dentro del metodo
    //throws : Propaga la cantidad (solo multiplos de 100), se colca en la firma o definicion del metodo
    //Pregunta de entrevista el uso de try and catch se ocupa para manejar las exception y tambien conosco la propagacion de exceptions el throw y throws

    @Override   //momento 1
    public List<Object> retirar(CuentaDTO cuenta, double monto) throws AccountNotFoundException,WrongNipException, InsufficentBalanceException, UnderMinimunLimitException {

        Ticket ti = null;
        List<Object> data = new ArrayList<>();

        if (monto > cuenta.getSaldo()) {
            throw new InsufficentBalanceException("Saldo insuficiente");
            //imprimo el saldo
            //System.out.println("Saldo insuficiente");
        } else if ((cuenta.getSaldo() - monto) < cuenta.getSaldoMin()) {
            throw new UnderMinimunLimitException("Retiro no disponible, limite inferior alcanzado");
            //System.out.println("Retiro no disponible, limite inferior alcanzado");
        } else {
            //Calcular el indice donde tome el objeto original
            int index = Atm.getDbcuentas().indexOf(cuenta);
            //retirar(descontar el monto)
            cuenta.setSaldo(cuenta.getSaldo() - monto);
            //actualizar el saldo de la cuenta(la que esta en la lista, reemplazando al objeto)
            Atm.getDbcuentas().set(index, cuenta);

            //invocar al metodo que registrea el movimiento
            movDAO.registrarMovimiento(new Movimiento(0, cuenta.getCuentaId(), "RETIRO", Date.valueOf(LocalDate.now()), monto));

            cuentaDAO.actualizarSaldo(cuenta.getNumCuenta(), cuenta.getSaldo());

            //generar el ticket
            ti = new Ticket(this.getUbicacion(), LocalDate.now(), cuenta.getNumCuenta(), "RETIRO", monto, "RT" + (Atm.folioOperacion++));
            //anade los elementos resultantes a la lista de salida
            data.add(ti);
            data.add(monto);
        }
        return data;
    }
}