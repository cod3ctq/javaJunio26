package Paquete2;

import Paquete1.ClaseOrigen;
/*
El extends: Permite extender el el alcance de los attributos que estan como protected
 */
public class ClaseLejana extends ClaseOrigen {

    public ClaseLejana(){
        this.valor1 = "algo"; //Es public
        //origen.texto1(); ERROR, por que es private
        //origen.numero1 = 34; ERROR, por que es protected
        this.numero1 = 34;
    }
}
