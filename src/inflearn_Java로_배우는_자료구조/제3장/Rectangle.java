package inflearn_Java로_배우는_자료구조.제3장;

public class Rectangle extends Shape {
    public int width;
    public int height;

    public Rectangle(int w, int h) {
        super("Rectangle");
        width = w;
        height = h;
    }
    @Override
    public double computeArea() {
        return (double) width*height;
    }

    @Override
    public double computePerimeter() {
        return 2.0*(width+height);
    }

    public String toString() {
        return "Rectangle width is " + width + ", height is " + height;
    }
}
