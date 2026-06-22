package Paquete1;

/*
Encapsulamiento:
Controlar el acceso / visibilidad/ de los mienbros de una clase a traves de 3 modificaciones de acceso( public, protected, private)
Desarrollo en capas
Esta en clase main esta en el paquete default

//Preguntas de entrevista
Abstraccion
Encapsulamiento
 */
public class Main {
    public static void main(String[] args) {

        ClaseOrigen co1 = new ClaseOrigen();

        //Asignar un valor a un atributo directamenete
        co1. numero1 = 10; //protected
        co1.valor2 = "Hola"; //public
        //co1.texto1 ="Java"; //Da error por que es privado

        //La forma CORRECTA de acceder a un trributo de clase no importando su modificador de acceso es siempre atravesde getters y setters (PORQUE SON PUBLICOS)
        co1.setValor1("dfghjk");
        co1.getTexto2();
    }
}
