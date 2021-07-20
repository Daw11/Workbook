package ires.patterns.ocp;

public class Square extends Shape {

    public Square() {
        this.shapeType = ShapeType.Square;
    }

    public void draw(){
        System.out.println("drawSquare");
    }

}

