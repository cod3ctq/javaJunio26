public interface IOperacionesAvanzadas {

    Ticket depositar(String dato, double monto); //Determinar QUE es dato
    Ticket pagarServicio(String dato, String convenio, String referencia);
    Ticket pagarTarjeta(String numTarjeta, double monto);

}
