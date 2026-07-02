public interface IOperacionesAvanzadas {

    Ticket depositar(double monto);
    Ticket depositar(String dato, double monto); //Determinar QUE es dato
    Ticket pagarServicio(String convenio, String referencia);
    Ticket pagarTarjeta (String numTarjeta, double monto);
}
