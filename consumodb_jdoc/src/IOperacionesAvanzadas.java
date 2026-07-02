public interface IOperacionesAvanzadas {

    Ticket depositar (double monto);
    Ticket depositar (String dato, double monto);
    Ticket pagarServicios (String convenio, String referencia);
    Ticket pagarTarjeta (String numTarjeta, double monto);


}
