package service;

import dto.CuentaDTO;

public interface IOperacionesAvanzadas {

    Ticket depositar(CuentaDTO cuenta, double monto); //Determinar QUE es dato
    Ticket pagarServicio(CuentaDTO cuenta, String convenio, String referencia);
    Ticket pagarTarjeta (String numTarjeta, double monto);
}
