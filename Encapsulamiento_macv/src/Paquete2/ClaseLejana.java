package Paquete2;

import Paquete1.ClaseOrigen;

public class ClaseLejana extends ClaseOrigen {



    public ClaseLejana(){


        //Al heredar de una clase de otro paquete
        //protected extiende su visibilidad
        this.valor1= "algo";
        this.numero1= 45;



       // origen.texto1 = ""; ERROR, es private
        //origen.numero1  34; ERROR, es protected
    }






}
