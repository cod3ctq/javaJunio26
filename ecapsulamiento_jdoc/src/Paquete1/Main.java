package Paquete1;


public class Main {
    public static void main(String[] args) {

        ClaseOrigen co1= new ClaseOrigen();
        //Asiganer un valor a un atributo directamente (INCORRECTO)
        co1.nuemro1=10;//peotected
        co1.valor2="hola";//public
        //co1.texto1="java"; aqui da ERROR porque es "private"

        //La forma correcata de acceder a un atributo de clase
        //(no importando su modificador de acceso)
        //eS siempre a traves de getter y setters (PORQUE SON PUBLICOS)

        co1.setValor1("65435435413");
        co1.getTexto1();








    }
}