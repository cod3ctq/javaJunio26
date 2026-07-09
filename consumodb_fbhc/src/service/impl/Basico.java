package service.impl;

import constants.Mensajes;
import dao.CuentaDAO;
import dao.MovimientoDAO;
import dto.CuentaDTO;
import exception.*;
import models.Atm;
import models.Tiket;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Basico extends Atm implements IOperacionesBasicas {

    private final MovimientoDAO movDAO = new MovimientoDAO();
    private final CuentaDAO cuentaDAO = new CuentaDAO();


    @Override
    public List<Object> cobrarRetiroSinTarjeta() {
        Scanner scan = new Scanner(System.in);
        String referencia = "";
        Tiket tiket = null;
        List<Object> respuesta = new ArrayList<Object>();
        System.out.println("Capturar la referencia - 16 digitos ");
        referencia = scan.nextLine();
        if (referencia.length() != 16) {
//            System.out.println("Referencia invalida");
            throw new InvalidReferenceEception(Mensajes.INVALID_REFERENCE);
        } else if (getRetirosCobrados().contains(referencia)) {//Validar  si ya fue cobrada
//            System.out.println("Esta referencia ya fue cobrada !");
            throw new AlredyCollectedException(Mensajes.ALREDY_PAIDED);
        } else {
            String numCuenta = "";
            double monto = 0.0;

            for (String key : getCaheRetirosST().keySet()) {
                if (key.split(":")[1].equals(referencia)) {
                    numCuenta = key.split(":")[0];
                    monto = getCaheRetirosST().get(key);
                    break;
                }

            }
//Marcar como cobrado este retiro (agregar al set)
            getRetirosCobrados().add(referencia);
            //Adquirir los datos de la tarjeta de donde se obtendran los datos
            CuentaDTO dto = buscarCuenta(numCuenta);
            //Descuenta el dinero de la cuenta
            cuentaDAO.actualizarSaldo(numCuenta, dto.getSaldo() - monto);
            movDAO.registrarMovimiento(new Movimientos(0, dto.getCuentaId(),
                    "RETIRO", Date.valueOf(LocalDate.now()), monto));
            //instancia el objeto tiket
            tiket = new Tiket(this.getUbicacion(), LocalDate.now(), numCuenta, "RETIRO", monto, "RT" + (folioOperacion++));
            //Construye la lista de salida
            respuesta.add(tiket);
            respuesta.add(monto);
        }

        return respuesta;


    }

    // Propagacion de excepciones  : thorow y throws
    //trow: crea la ecepcion el punto necesario del flujo se coloca dentro del metodo
    //trows propaga la ecepcion se coloca en la firma del metodo
    public List<Object> retirar(CuentaDTO cuenta, double monto) throws AccountNotFoundException, InsuffeicentBalanceException,
            UnderMinimunLimitException {
        //VALIDAR  LIMITEDE MONTO ($$$)DE RETIRO DIARIO
        Tiket t1 = null;
        List<Object> data = new ArrayList<>();
        //Si la cuenta existe
        if (monto > cuenta.getSaldo()) {
            //Imprimir el saldo
            throw new InsuffeicentBalanceException("Sldo insuficiente");
            //System.out.println("Sldo insuficiente");
        } else if ((cuenta.getSaldo() - monto) < cuenta.getSaldoMin()) {
            throw new UnderMinimunLimitException("Retiro no disponible, limite inferior alcanzado");
            //validar que (saldo disponible - monto) > saldo minimo de la cuenta
            //System.out.println("Retiro no disponible, limite inferior alcanzado");
        } else {
            //Calcular el indice de donde tome el objeto original
            int index = getDbcuentas().indexOf(cuenta);
            //retirar (descontar el monto)
            //actualizar el saldo de la cuenta
            cuenta.setSaldo(cuenta.getSaldo() - monto);
            //actualizar el saldo de la cuenta (la que esta en la lista )
            getDbcuentas().set(index, cuenta);
            //generar el tiket
            //invocar el moviiento que genera el  movimiento
            movDAO.registrarMovimiento(new Movimientos(0, cuenta.getCuentaId(),
                    "RETIRO", Date.valueOf(LocalDate.now()), monto));
            //invocar al metodo que que actualiza los saldos de las cuentas
            cuentaDAO.actualizarSaldo(cuenta.getNumCuenta(), cuenta.getSaldo());
            //Instancia el objeto T
            t1 = new Tiket(this.getUbicacion(), LocalDate.now(),  //1234
                    cuenta.getNumCuenta(), "RETIRO", monto, "RT" + (folioOperacion++));
            //añade los elemntos resultantes a la lista de salida
            data.add(t1);
            data.add(monto);
        }
        //retorna resultados
        return data;
    }


}
