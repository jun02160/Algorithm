package inflearn_Java로_배우는_자료구조.제3장;

public abstract class Shape implements MyComparable {
    public String shapeName;

    public Shape(String name) {
        shapeName = name;
    }

    public abstract double computeArea();
    public abstract double computePerimeter();

    public int compareTo(Object o) {
        double myArea = computeArea();
        double yourArea = ((Shape)o).computeArea();
        if (myArea < yourArea) return -1;
        else if (myArea == yourArea) return 0;
        else return 1;
    }
}
