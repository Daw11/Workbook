package ires.corso.parttwo.firstclasses.geometric;

import java.util.Scanner;

public class Triangolo extends MasterShape {
    private double[] sides;

    public Triangolo(){
        sides = new double[3];
        for(int i = 0; i < 3; i++)
            sides[i] = 0;

        Scanner in = new Scanner( System.in );
        System.out.println("Inserisci la lunghezza dei 3 lati del triangolo (separa i numeri con un |): ");
        String[] strSides = in.nextLine().split("\\|");
        if( strSides.length != 3 ){
            System.out.println("Errore, il numero di lati del triangolo che dovevi inserire è 3.");
            return;
        }
        for(int i = 0; i < 3; i++)
            sides[i] = Double.parseDouble( strSides[i] );
    }

    public Triangolo( double[] sides ){
        this.sides = new double[3];
        for(int i = 0; i < 3; i++)
            this.sides[i] = 0;

        if( sides.length != 3 ){
            System.out.println("Errore, il numero di lati del triangolo deve essere 3");
            return;
        }

        this.sides = sides;
    }

    @Override
    public double computeArea(){
        double semiperimeter = computePerimeter() / 2;
        double result = semiperimeter * ( semiperimeter - sides[0] ) * ( semiperimeter - sides[1] ) * ( semiperimeter - sides[2] );
        result = Math.sqrt( result );
        return result;
    }

    @Override
    public double computePerimeter(){
        double perimeter = 0;
        for(double side : sides)
            perimeter += side;
        return perimeter;
    }
}
