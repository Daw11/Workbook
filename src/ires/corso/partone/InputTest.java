package ires.corso.partone;
import java.util.Scanner;

public class InputTest {

    public static void main(String[] args) {
        Scanner in = new Scanner( System.in );
	    System.out.println("Inserisci il primo valore: ");
	    Integer a = in.nextInt();
        System.out.println("Inserisci il secondo valore: ");
        Integer b = in.nextInt();
        System.out.println("Inserisci il terzo valore: ");
        Integer c = in.nextInt();
        Integer maxVal;
        String maxPos;

        if( a >= b ) {
            maxVal = a;
            maxPos = "PRIMO";
        }
        else {
            maxVal = b;
            maxPos = "SECONDO";
        }

        if( c > maxVal ) {
            maxVal = c;
            maxPos = "TERZO";
        }

        System.out.println("Il numero maggiore che hai inserito è il " + maxPos + " e vale: " + maxVal);
    }
}
