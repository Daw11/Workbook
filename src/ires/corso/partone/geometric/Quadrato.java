package ires.corso.partone.geometric;

import java.util.Scanner;

public class Quadrato {

    public static double conputeArea( double side ){
        return side * side;
    }

    public static double getAreaFromInput( Scanner in ){
        System.out.println("Inserisci la lunghezza del lato: ");
        double side = in.nextDouble();

        return conputeArea( side );
    }
}
