public interface IOperacionesAvanzandas {
    Ticket depositar(double monto);
    Ticket depositar(String dato, double monto);
    Ticket pagarServicio(String convenio,String referencia);
    Ticket pagarTarjeta(String numTarjeta ,double monto);
}
