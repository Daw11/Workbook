package ires.corso.partone;
import java.util.Scanner;

public class LoopTest {
    public static void main(String[] args) {
        test2();
    }

    public static void test1(){
        Scanner in = new Scanner( System.in );
        int i, j, rows, n;

        System.out.println("Input number of rows:");
        rows = in.nextInt();

        n = 1;
        for(i = 1; i <= rows; i++){
            for(j = 0; j < i; j++){
                System.out.print( n++ );
            }
            System.out.print('\n');
        }
    }

    public static void test2(){
        int i;
        int d = 7;

        for(i = 1; i <= d; i++)
        {
            computeAndPrintDiamondNumbers(i, d);
        }

        for(i = d - 1; i >= 1; i--)
        {
            computeAndPrintDiamondNumbers(i, d);
        }
    }
    /*
        VARIAZIONE: per d = 7

              1
             212
            32123
           4321234
          543212345
         65432123456
        7654321234567
         65432123456
          543212345
           4321234
            32123
             212
              1
     */

    public static void computeAndPrintDiamondNumbers(int lineIndex, int diamondSize) {
        int numSpaces = diamondSize - lineIndex;      // Numero di spazi
        printDiamondNumbers(numSpaces, lineIndex);
    }

    public static void printDiamondNumbers(int spaces, int chars) {
        int j;
        for(j = 1; j <= spaces; j++)System.out.print(" ");
        for(j = chars; j >= 1; j--) System.out.print( j );
        for(j = 2; j <= chars; j++) System.out.print( j );
        System.out.print("\n");
    }
}
