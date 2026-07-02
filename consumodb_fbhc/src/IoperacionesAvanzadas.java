public interface IoperacionesAvanzadas {

    Tiket depositar (double monto);
    Tiket depositar(String dato, double monto);
    Tiket pagarservisio(String convenio, String referencia);
    Tiket pagarTarjeta (String miTarjeta ,double monto);



}
