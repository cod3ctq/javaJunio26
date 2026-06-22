package paquete2;

import Paquete1.ClaseOrigen;



public class ClaseLejana extends ClaseOrigen{


    public ClaseLejana() {

        this.valor1 = "algo"; //Es public

        // origen.texto1 = "8475296438
        // origen.numero1 = 34; error por que es protected
        //Al heredar de una clase de otro paquete
        //protected extiende su visibilidad



        this.numero1 = 34;


    }
}
