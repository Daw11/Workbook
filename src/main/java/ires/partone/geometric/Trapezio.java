package ires.partone.geometric;
import java.util.Scanner;

public class Trapezio {

    public static double conputeArea( double bmaj, double bmin, double height ){
        return ( bmaj + bmin ) * height / 2;
    }

    public static double getAreaFromInput( Scanner in ){
        System.out.println("Inserisci il lato maggiore: ");
        double bmaj = in.nextDouble();

        System.out.println("Inserisci il lato minore: ");
        double bmin = in.nextDouble();

        System.out.println("Inserisci l'altezza: ");
        double height = in.nextDouble();

        return conputeArea(bmaj, bmin, height);
    }
}
