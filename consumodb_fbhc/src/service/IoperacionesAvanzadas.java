package service;

public interface IoperacionesAvanzadas {


    Tiket depositar(CuentaDTO cuenta, double monto);
    Tiket pagarservisio(CuentaDTO cuenta, String convenio, String referencia);
    Tiket pagarTarjeta (String miTarjeta , double monto);



}
