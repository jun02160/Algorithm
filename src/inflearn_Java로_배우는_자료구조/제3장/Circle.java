package inflearn_Java로_배우는_자료구조.제3장;

public class Circle extends Shape{
    public int radius;

    public Circle(int r) {
        super("Circle");
        radius = r;
    }

    @Override
    public double computerArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double computerPerimeter() {
        return 2.0*Math.PI*radius;
    }

    public String toString() {
        return "Circle: radius is " + radius;
    }
}
