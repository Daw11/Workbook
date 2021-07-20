package ires.patterns.ocp;

public abstract class Shape implements IShape {

    protected enum ShapeType {
        Circle,
        Square
    }

    protected ShapeType shapeType;

    public static void drawAll(Shape[] shapes){
        for (IShape shape: shapes)
            shape.draw();
    }
}
