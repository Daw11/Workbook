package ires.corso.partone;
import java.util.Scanner;
import ires.corso.partone.geometric.*;

public class ShapeTest {
    public static void main(String[] args){
        Scanner in = new Scanner( System.in );

        System.out.println("Inserisci il nome della figura: (Quadrato/Trapezio/Triangolo)");
        String shape = in.nextLine();

        double area;

        switch( shape ){
            case "Quadrato":
                area = Quadrato.getAreaFromInput( in );
                break;

            case "Trapezio":
                area = Trapezio.getAreaFromInput( in );
                break;

            case "Triangolo":
                area = Triangolo.getAreaFromInput( in );
                break;

            default:
                System.out.println("Il nome inserito non è valido.");
                return;
        }

        System.out.println("L'area è: " + area);
    }
}
