package ires.corso.partone;
import java.util.Scanner;

public class ArrayTest {
    public static void main(String[] args) {
        test2();
    }

    public static void test1(){
        int[] intArray = inputArray();

        System.out.println("Inserisci il valore da trovare");
        Scanner in = new Scanner( System.in );
        int elem = in.nextInt();

        int result = elemPositionInArray( intArray, elem );
        if( result == -1 )
            System.out.println("Elemento non trovato");
        else
            System.out.printf("L'elemento selezionato ha come posizione: %d", result);
    }

    public static void test2() {
        int[] arrayWithDuplicates = inputArray();
        int[] arrayWithoutDuplicates = removeDuplicates(arrayWithDuplicates);

        System.out.println("L'array senza i duplicati è: ");
        for(int i = 0; i < arrayWithoutDuplicates.length; i++)
            System.out.print( arrayWithoutDuplicates[i] + "|" );
    }

    public static int[] inputArray(){
        Scanner in = new Scanner( System.in );
        System.out.println("Inserisci un array (numeri separati da |, es 1|2|3): ");
        String str = in.nextLine();
        String[] strArray = str.split("\\|");
        int[] intArray = new int[strArray.length];

        for( int i = 0; i < strArray.length; i++ ){
            intArray[i] = Integer.parseInt( strArray[i] );
        }

        return intArray;
    }

    public static int elemPositionInArray(int[] intArray, int elem){
       for( int i = 0; i < intArray.length; i++ ){
           if( intArray[i] == elem )
               return i;
       }

        return -1;
    }

    public static int[] removeDuplicates(int[] arrayWithDuplicates){
        int arrayLength = 0;
        for( int i = 0; i < arrayWithDuplicates.length; i++ ){
            int pos = elemPositionInArray(arrayWithDuplicates, arrayWithDuplicates[i]);
            if( pos == i )
                arrayLength++;
        }

        int[] arrayWithoutDuplicates = new int[arrayLength];

        int j = 0;
        for( int i = 0; i < arrayWithDuplicates.length; i++ ){
            int elem = arrayWithDuplicates[i];
            int pos = elemPositionInArray(arrayWithDuplicates, elem );
            if( pos == i ) {
                arrayWithoutDuplicates[j] = elem;
                j++;
            }
        }

        return arrayWithoutDuplicates;
    }
}
