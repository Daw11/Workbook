package ires.patterns.ocp;

public class Main {

    public static void main(String[] args) {
        Shape[] shapes = new Shape[]{ new Circle(), new Square()};
        Shape.drawAll(shapes);
    }

}
