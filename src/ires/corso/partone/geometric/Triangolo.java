package ires.corso.partone.geometric;

import java.util.Scanner;

public class Triangolo {

    public static double conputeArea( double base, double height ){
        return base * height / 2;
    }

    public static double getAreaFromInput( Scanner in ){
        System.out.println("Inserisci la base: ");
        double base = in.nextDouble();

        System.out.println("Inserisci l'altezza: ");
        double height = in.nextDouble();

        return conputeArea( base, height );
    }
}
