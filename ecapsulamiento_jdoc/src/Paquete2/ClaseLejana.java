package Paquete2;

import Paquete1.ClaseOrigen;

public class ClaseLejana extends ClaseOrigen{


    public ClaseLejana(){

        this.valor2="algo";// Es public
        //origen.texto1= "651654684648"; "ERROR" es private
        //origen.numero1= 34; "ERROR" por que es protected


        //Al hereedar de una clase de otro paquete
        //protected extiende su visivilidad

        this.nuemro1=34;



    }
}
