package Paquete1;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        ClaseOrigen co1 = new ClaseOrigen();

        //Asignar un valor a un atributo directamente(INCORRECTO)

        co1.numero1=10; // portected
        co1.valor2="hola";//public
        //co1.texto1 = "java"; ERROR POR QUE ES PRIVATE


        // La forma correcta que acceder a un atributo de clase
        //(no importando su modificador de acceso)
        // es siempre a traves de getter y setters (por que no son PUBLICO)
        co1.setValor1("kbbivyui");
        co1.getTexto2();


    }
}