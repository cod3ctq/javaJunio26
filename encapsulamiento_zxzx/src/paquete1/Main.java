package paquete1;

public class Main {
    public static void main(String[] args) {

        ClaseOrigen co1 = new ClaseOrigen();

        //Asignar un valor a un atributo directamente (INCORRECTO)
        co1.numero1 = 10; //protected
        co1.valor2 = "hola"; //public
        //co1.texto1 = "Java"; ERROR, por que es private

        //La forma CORRECTA de acceder a un atributo de clase
        //(no importanto su modificador de acceso)
        //es siempre a traves de getter y setters (por que son PUBLICOS)
        co1.setValor1("sdfvdf");
        co1.getTexto2();

    }
}