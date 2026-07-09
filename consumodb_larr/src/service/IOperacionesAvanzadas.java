package service;

import dto.CuentaDTO;
import models.Ticket;

public interface IOperacionesAvanzadas {

    Ticket depositar(CuentaDTO cuenta, double monto); // Determinar QUÉ es dato
    Ticket pagarServicio(CuentaDTO cuenta, String convenio, String referencia);
    Ticket pagarTarjeta(String numTarjeta, double monto);





}
