//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Camara c1= new Camara( "1800p", 50, "buena",20);
        Camara c2= new Camara( "1800p", 50, "buena",20);
        Camara c3= new Camara( "1800p", 50, "buena",20);
        
        Pantalla p1 = new Pantalla();
        Camara[] camaras = new Camara[10];

        camaras[0]=c1;
        camaras[1]=c2;
        camaras[2]=c3;

        Camara c4 = new Camara("490p", 10, "simpleCamera", 100);
        Camara c5 = new Camara("480p", 2, "simple", 120);
        Camara[] camarasViejas = new Camara[2];
        camarasViejas[0] = c4;
        camarasViejas[1] = c5;

        Basico telefonoViejo = new Basico("Nokia", "3310", 1200.0, "Baja", "Plástico", camarasViejas);

        //para contrurir objetos compuesto antes deno crear un objeto de mi objeto principal
        Smartphone t1=new Smartphone("samsung","s23 Ultra",100000.2,"Alta", "5000",true, "android", true, 1  , camaras, p1);
        Smartphone t2=new Smartphone("samsung","a95",80000.2,"Alta", "aluminio",true,
                              "Symbian", false, 10  , camarasViejas, p1);

        System.out.println(t1.toString());
        System.out.println(t2.toString());
        
    }
}