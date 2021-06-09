package ires.corso.partone;
import java.util.Scanner;

public class ArrayTest {
    public static void main(String[] args){
        Scanner in = new Scanner( System.in );
        System.out.println("Inserisci un array (numeri separati da |, es 1|2|3): ");
        String str = in.nextLine();
        String[] strArray = str.split("\\|");
        int[] intArray = new int[strArray.length];

        for( int i = 0; i < strArray.length; i++ ){
            intArray[i] = Integer.parseInt( strArray[i] );
        }

        System.out.println("Inserisci la posizione dell'elemento (partendo da 0): ");
        int elem = in.nextInt();

        int result = elemPositionInArray( intArray, elem );
        if( result != -1 )
            System.out.printf("L'elemento selezionato ha come valore: %d", result);
    }

    public static int elemPositionInArray(int[] intArray, int elem){
        if( elem < 0 || elem > intArray.length - 1 ){
            System.out.println("Errore, la dimensione inserita non è valida");
            return -1;
        }
        return intArray[elem];
    }
}
