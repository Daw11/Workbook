package ires.corso.parttwo.firstclasses.geometric;

import ires.corso.parttwo.firstclasses.geometric.Triangolo;

import java.util.Scanner;

public class Trapezio extends MasterShape {
    private double[] sides;

    private final int BMAG = 0;
    private final int BMIN = 1;
    private final int L1 = 2;
    private final int L2 = 3;

    public Trapezio(){
        sides = new double[4];
        for(int i = 0; i < 4; i++)
            sides[i] = 0;

        Scanner in = new Scanner( System.in );
        System.out.print("Inserisci la lunghezza della base maggiore del trapezio: ");
        sides[BMAG] = in.nextDouble();
        System.out.print("Inserisci la lunghezza della base minore del trapezio: ");
        sides[BMIN] = in.nextDouble();
        if( sides[BMAG] <= sides[BMIN] ){
            System.out.println("Errore, la base maggiore del trapezio deve essere più grande della base minore.");
            return;
        }
        System.out.print("Inserisci la lunghezza degli altri due lati del trapezio (separa i numeri con un |): ");
        in.nextLine(); // Clear previous nextDouble
        String[] strSides = in.nextLine().split("\\|");
        if( strSides.length != 2 ){
            System.out.println("Errore, il numero di lati del trapezio che dovevi inserire è 2.");
            return;
        }

        sides[L1] = Double.parseDouble( strSides[0] );
        sides[L2] = Double.parseDouble( strSides[1] );
    }

    @Override
    public double computeArea(){
        // Calculate the height of the trapezoid
        double bmag_minus_bmin = sides[BMAG] - sides[BMIN];
        double[] triangleSides = new double[3];
        triangleSides[0] = bmag_minus_bmin;
        triangleSides[1] = sides[L1];
        triangleSides[2] = sides[L2];
        Triangolo triangle = new Triangolo( triangleSides );
        double triangleArea = triangle.computeArea();
        double altezzaTrapezio = triangleArea * 2 / bmag_minus_bmin;
        return ( sides[BMAG] + sides[BMIN] ) * altezzaTrapezio / 2;
    }

    @Override
    public double computePerimeter(){
        double perimeter = 0;
        for(double side : sides)
            perimeter += side;
        return perimeter;
    }
}
