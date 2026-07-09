package util;

import java.util.Random;

public class CuentaHelper {

    static Random random = new Random();

    //generar referencias numericas de 16 digitos de manera aleatoria
    public static String generarReference(){
        StringBuilder referenceia = new StringBuilder();
        for (int i = 0; i < 16; i++) {
            int digito = random.nextInt(10);
            referenceia.append(digito);
        }
        return referenceia.toString();
    }

    //generar referencias numericas de 4 digitos de manera aleatoria
    public static String generarClave(){
        StringBuilder referenceia = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            int digito = random.nextInt(10);
            referenceia.append(digito);
        }
        return referenceia.toString();
    }

    //genera cantidades aleatorias, siempre son mulltiplos de 100
    public static String generarMonto(){
        int base = random.nextInt(99)+1;
        int resultado = base * 100;
        return String.format("%04d",resultado);
    }
}
