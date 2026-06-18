public class Main {
    public static void main(String[] args) {
        //Objeto de una clase comun y corriente
        Celular c1 = new Celular("Sony", "XZ", "ALTA",300.00,"300");

        //OInvocar los metoos propios de esta clase
//
//        c1.llamar("456789");
//        c1.mandarMensaje("45678","dfghj");
//        c1.crearContacto();

        //--COMPOSICION

        //Para contruir objetos compuestos, primero debo construir aquellos objetos
        //de los que se compone mi objeto principal

        String[] conectividad = {"2g","3g","4g","5g","Wifi","bluetooth", "GPS","NFC"};

        Pantalla display = new Pantalla(120, "2k","AMOLED", "gorilla glass",6.8,500);

        //Objetos
        Camara cam1 = new Camara("200",10,"ultra",1000);
        Camara cam2 = new Camara("100",20,"macro",2000);
        Camara cam3 = new Camara("50",5,"TOF",3000);
        Camara cam4 = new Camara("150",15,"Teleobjetivo",2000);
        Camara cam5 = new Camara("150",15,"Teleobjetivo",2000);

        //Array de camaras
        Camara[] cams = {cam1,cam2,cam3,cam4};

        Smartphone sm = new Smartphone("samsung","S21","alta",2000,"5000",true,true,512,"android",display,conectividad,cams);

        Pantalla display2 = new Pantalla(30,"234", "TFT", "",2.8,100);

        String[] conect = {"2g","3g","4g","5g","Wifi","bluetooth", "GPS","NFC"};

        Camara[] camaras = {cam5};

        Smartphone sm2 = new Smartphone("nokia","hh","alta",2000,"5000",true,true,512,"android",display2,conect,camaras);

        System.out.println(c1);
        System.out.println(sm);
        System.out.println(sm2);


    }
}
