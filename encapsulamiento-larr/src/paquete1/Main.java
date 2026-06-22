package paquete1;

public class Main {
    public static void main(String[] args) {

        ClaseOrigen co1 = new ClaseOrigen();

        // Asignar un valor a un atributo directamente (INCORRECTO)
        co1.numero1 = 10; // protected
        co1.valor2 = "Hola"; // public
//      co1.texto1 = "Java"; //ERROR porque es private.


        // La forma CORRECTA de acceder a un atributo de clase (no importando su modificador de acceso), es siempre
        // a traves de GETTER y SETTER (porque son publicos)

        co1.setValor1("sdfgh");
        co1.setTexto2("mhas");
        co1.setNumero1(45);
        co1.getTexto2();


    }
}