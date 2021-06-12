package ires.corso.parttwo.firstclasses.geometric;

import java.util.Scanner;

public class Quadrato extends MasterShape {
    private double side;

    public Quadrato(){
        Scanner in = new Scanner( System.in );
        System.out.print("Inserisci la lunghezza del lato del quadrato: ");
        side = in.nextDouble();
    }

    @Override
    public double computeArea(){
        return side * side;
    }

    @Override
    public double computePerimeter(){
        return side * 4;
    }
}
