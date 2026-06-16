import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //Variables para los archivos
        String nameInput="C:\\Users\\DELL\\IdeaProjects\\poryectoTodo\\tempFiles\\datesInput.txt";
        String nameOutput="C:\\Users\\DELL\\IdeaProjects\\poryectoTodo\\tempFiles\\datesOutput.txt";

        File fileInput = new File(nameInput);
        File fileOut = new File(nameOutput);

        //variables fecha en palabras
        String readLine;
        String tempNumDay="";
        String tempNumMon;
        String tempNumYear;

        String finalDateWord = "";
        String finalSentencesNextLetter;
        char tempChar;
        int tempNumber;
        int indexBeforeYear;


        //variables vocabulario
        String abecedario = "abcdefghijklmnopqrstuvwxyz";
        String tempSentence = "";


        try {
            FileReader fr= new FileReader(fileInput);
            FileWriter fw= new FileWriter(fileOut);
            BufferedReader br= new BufferedReader(fr);

           while( (readLine= br.readLine())!=null){
               tempNumber = Integer.parseInt(readLine.substring(0,2));

               //calcuñar dia
               if(tempNumber>10 && tempNumber<16){
                   switch (tempNumber) {
                       case 11 -> finalDateWord = "once de ";
                       case 12 -> finalDateWord = "doce de ";
                       case 13 -> finalDateWord = "trece de ";
                       case 14 -> finalDateWord = "catorce de ";
                       case 15 -> finalDateWord = "quince de ";
                   };
               }else{
                   if (tempNumber > 9) {
                       switch (readLine.charAt(0)) {
                           case '1' -> {
                               if (readLine.charAt(1) == '0') {
                                   finalDateWord = "diez de";
                               } else {
                                   finalDateWord = "dieci";
                               }

                           }
                           case '2' -> {
                               if (readLine.charAt(1) == '0') {
                                   finalDateWord = "veinte de ";
                               } else {
                                   finalDateWord = "veinti";
                               }
                           }
                           case '3' -> finalDateWord = "treinta de ";
                           default -> finalDateWord = "";
                       };

                       switch (readLine.charAt(1)) {
                           case '0' -> finalDateWord += "de ";
                           case '1' -> finalDateWord += "uno de ";
                           case '2' -> finalDateWord += "dos de ";
                           case '3' -> finalDateWord += "tres de ";
                           case '4' -> finalDateWord += "cuatro de ";
                           case '5' -> finalDateWord += "cinco de ";
                           case '6' -> finalDateWord += "sies de ";
                           case '7' -> finalDateWord += "siete de ";
                           case '8' -> finalDateWord += "ocho de ";
                           case '9' -> finalDateWord += "nueve de ";
                           default -> finalDateWord += " de ";
                       }
                   }
               }

               //calcular mes
               tempNumber = Integer.parseInt(readLine.substring(2,4));
               switch (tempNumber) {
                   case 1 -> finalDateWord += "enero del ";
                   case 2 -> finalDateWord += "febrero del ";
                   case 3 -> finalDateWord += "marzo del ";
                   case 4 -> finalDateWord += "abril del ";
                   case 5 -> finalDateWord += "mayo del ";
                   case 6 -> finalDateWord += "junio del ";
                   case 7 -> finalDateWord += "Julio del ";
                   case 8 -> finalDateWord += "agosto del ";
                   case 9 -> finalDateWord += "septiembre del ";
                   case 10 -> finalDateWord += "octubre del ";
                   case 11 -> finalDateWord += "noviembre del ";
                   case 12-> finalDateWord += "diciembre del ";
                   default -> finalDateWord +=" de ";
               }

               indexBeforeYear=finalDateWord.length();

               //calcular dia
               tempNumYear=readLine.substring(5,readLine.length()-1);
               tempChar = readLine.charAt(4);
               switch (tempChar){
                   case '1' -> finalDateWord +="mil ";
                   case '2' -> finalDateWord +="dos mil ";
                   case '3' -> finalDateWord +="tres mil ";
                   default -> System.out.println("salio de rango ");
               };

               tempChar = readLine.charAt(5);
               switch (tempChar){
                           case '0' ->  finalDateWord +="";
                           case '1' ->  finalDateWord +="cien ";
                           case '2' ->  finalDateWord +="dociento ";
                           case '3' ->  finalDateWord +="trecientos ";
                           case '4' ->  finalDateWord +="cuatrocientos ";
                           case '5' ->  finalDateWord +="quinientos ";
                           case '7' ->  finalDateWord +="seicioentos ";
                           case '8' ->  finalDateWord +="setecientos ";
                           case '9' ->  finalDateWord +="novecientos ";
                       };

               tempNumber = Integer.parseInt(readLine.substring(6,8));
               if(tempNumber>10 && tempNumber<16){
                           switch (tempNumber) {
                               case 11 -> finalDateWord = "once";
                               case 12 -> finalDateWord = "doce";
                               case 13 -> finalDateWord = "trece";
                               case 14 -> finalDateWord = "catorce";
                               case 15 -> finalDateWord = "quince";
                           };
                       }else {
                   if (tempNumber > 9) {
                       switch (readLine.charAt(6)) {
                           case '1' -> {
                               if (readLine.charAt(7) != '0') {
                                   finalDateWord += "dieci";
                               } else {
                                   finalDateWord += "diez ";
                               }

                           }
                           case '2' -> {
                               if (readLine.charAt(7) == '0') {
                                   finalDateWord += "veinte ";
                               } else {
                                   finalDateWord += "veinti";
                               }
                           }
                           case '3' -> finalDateWord += "treinta ";
                           case '4' -> finalDateWord += "cuarenta ";
                           case '5' -> finalDateWord += "cincuenta ";
                           case '6' -> finalDateWord += "sessenta ";
                           case '7' -> finalDateWord += "setenta ";
                           case '8' -> finalDateWord += "ochenta ";
                           case '9' -> finalDateWord += "noventa ";
                           default -> finalDateWord += "";
                       }
                   }
                   switch (readLine.charAt(7)) {
                       case '0' -> finalDateWord += "";
                       case '1' -> finalDateWord += "uno";
                       case '2' -> finalDateWord += "dos";
                       case '3' -> finalDateWord += "tres";
                       case '4' -> finalDateWord += "cuatro";
                       case '5' -> finalDateWord += "cinco";
                       case '6' -> finalDateWord += "sies";
                       case '7' -> finalDateWord += "siete";
                       case '8' -> finalDateWord += "ocho";
                       case '9' -> finalDateWord += "nueve";
                       default -> finalDateWord += "";
                   }
               }

               //una letra despues
               for (int indexLetterSentences =0;indexLetterSentences<indexBeforeYear;indexLetterSentences++){
                   if(finalDateWord.charAt(indexLetterSentences)==' '){
                       tempSentence+='-';
                   }else if(finalDateWord.charAt(indexLetterSentences)=='z'){
                       tempSentence+='a';
                   }else {
                       tempNumber=abecedario.lastIndexOf(finalDateWord.charAt(indexLetterSentences)+1);// calcular nueva letra
                       tempSentence+=abecedario.charAt( tempNumber);
                   }
               }

               //suma de años
               tempNumber=Character.getNumericValue(readLine.charAt(4)) + Character.getNumericValue(readLine.charAt(5)) +
                        Character.getNumericValue(readLine.charAt(6)) + Character.getNumericValue(readLine.charAt(7));
               tempSentence+=String.valueOf(tempNumber);

               fw.write(tempSentence+'\n');
               System.out.println(finalDateWord);
               System.out.println( tempSentence);
               tempSentence="";
               //ends while
           }
           fw.close();
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

    }
}