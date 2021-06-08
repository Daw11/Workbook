package ires.corso.partone;
import java.util.Scanner;

public class LoopTest {
    public static void main(String[] args){
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
}
