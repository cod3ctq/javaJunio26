package Paquete1;

public class Main {
    public static void main(String[] args) {

ClaseOrigen co1 = new ClaseOrigen();
// Asignar un valor a un atributo directamente

        co1.numero1 = 10;// protected
        co1.valor2 = "hola"; //public

        //co1.texo1 = "Java";   ERROR, por que es privado

        //La forma correcta de acceder a un atributo de clase
        //no importando su modificador de acceso
        //es siempre a traves de getter y setters (por que son publicos)

        co1.setValor1("dsfsdf");
        co1.getTexto2();

    }
}
