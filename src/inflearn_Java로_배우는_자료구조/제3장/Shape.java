package inflearn_Java로_배우는_자료구조.제3장;

public abstract class Shape {
    public String shapeName;

    public Shape(String name) {
        shapeName = name;
    }

    public abstract double computerArea();
    public abstract double computerPerimeter();
}
