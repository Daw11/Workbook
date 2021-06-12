package ires.corso.parttwo.firstclasses;

import ires.corso.parttwo.firstclasses.geometric.MasterShape;
import ires.corso.parttwo.firstclasses.geometric.Quadrato;
import ires.corso.parttwo.firstclasses.geometric.Trapezio;
import ires.corso.parttwo.firstclasses.geometric.Triangolo;

public class GeometricShapeTest {
    public static void main(String[] args){
        MasterShape[] shapes = new MasterShape[3];
        shapes[0] = new Quadrato();
        shapes[1] = new Trapezio();
        shapes[2] = new Triangolo();

        double totalArea = 0.0;
        double totalPerimeter = 0.0;

        for( MasterShape shape : shapes ){
            totalArea += shape.computeArea();
            totalPerimeter += shape.computePerimeter();
        }

        System.out.printf("Le figure che hai inserito hanno come area totale: %f\ne come perimetro totale: %f", totalArea, totalPerimeter);
    }
}
