package services;

import dto.CuentaDTO;
import models.Ticket;

public interface IOperacioneAvanzadas {

    Ticket depositar(CuentaDTO cuenta, double monto);
    Ticket pagarServicio(CuentaDTO cuenta, String convenio, String referencia);
    Ticket pagarTarjeta(String numTarjeta, double monto);
}
