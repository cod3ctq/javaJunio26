package paquete2;

import paquete1.ClaseOrigen;

public class ClaseLejana extends ClaseOrigen {


    public ClaseLejana(){

        this.valor1 = "algo";  //Es public
        //origen.texto1 = "84752964387"; ERROR, por que es private
        //origen.numero1 = 34; ERROR, por que es protected

        //Al heredar de una clase de otro paquete
        //protected extiende su visibilidad
        this.numero1 = 34;





    }






}
