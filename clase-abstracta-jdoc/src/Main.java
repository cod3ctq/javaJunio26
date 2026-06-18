//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Celular c1 = new Celular("NOKIA","1100", 1000, "Baja", "600", "plastico");

        //Invocar los metodos propios de esat calse

//        c1.llamar("64684351354");
//        c1.llamar("pepe","at&t");
//        c1.llamar("31541354",354331535);
//        c1.mandarMensaje("1654534133", "hola");
//        c1.crearContacto();
//
        //---COMPOSICION

        //Para construir objetos compuestos, priemro debo construir aquellos objetos
        //de los que se compone mi objeto principal

        String[] conectividad = {"2g","3g","4g","5g","wifi", "bluetooth","gps","NFC"};

        Pantalla display = new Pantalla(120,"2k","AMOLED","GORILLA GLAS VICTUS 2",6.2,500);
        Camara cam1 = new Camara("2000",100,"Ultra gran angular",200);
        Camara cam2= new Camara("50",10,"Macro",200);
        Camara cam3= new Camara("50",10,"Teleobjetivo",2000);
        Camara cam4= new Camara("12",5,"TOF",2000);

        Camara[] cams={cam1,cam2,cam3,cam4};


        Sartphone sm = new Sartphone("SAMSUMG","S23 ULTRA",10000,"Alta",
                "5000","Titanio",true,conectividad,"Android",
                true,512,display,cams);

        String[] coenc ={"2g","3g","wifi","Bluetooth","GPS","Infrarrojo","USB","Salida AV"};
        Pantalla display2 = new Pantalla(30,"360X240","TFT","",2.8,100);
        Camara cam5= new Camara("5",10,"Macro",800);

        Camara[] camaras={cam5};

        Sartphone sm2 = new Sartphone("Nokia","N95 8GB",8000,"Alta",
                "1200","Policarbonato",false,conectividad,"Symbian S60",
                false,8,display2,camaras);


        System.out.println(c1);
        System.out.println(sm); //S23 Ultra
        System.out.println(sm2); // N95 8GB





    }
}