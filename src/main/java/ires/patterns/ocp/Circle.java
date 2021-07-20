package ires.patterns.ocp;

public class Circle extends Shape {

    public Circle() {
        this.shapeType = ShapeType.Circle;
    }

    public void draw(){
        System.out.println("drawCircle");
    }

}
