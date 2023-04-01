package inflearn_Java로_배우는_자료구조.제3장;

import java.util.Scanner;

public class ShapeApplication {

    private int capacity = 10;
    private Shape[] shapes = new Shape[capacity];
    private int n = 0;
    private Scanner sc = new Scanner(System.in);


    public void processCommand() {
        while (true) {
            System.out.print("$ ");
            String command = sc.next();
            if (command.equals("add")) {
                handleAdd();
            } else if (command.equals("show") || command.equals("showdetail")) {
                handleShow(command.equals("showdetail"));
            } else if (command.equals("sort")) {
                MyUtilities.handleSort(shapes, n);
            } else if (command.equals("exit")) {
                break;
            }
            sc.close();
        }
    }

    // 면적의 크기를 기준으로 정렬 -> Bubble Sort 방식 이용
    /*private void handleSort() {
        for (int i=n-1; i>0; i--) {
            for (int j=0; j<i; j++) {
                if (shapes[j].computeArea() > shapes[j+1].computeArea()) {
                    Shape tmp = shapes[j];
                    shapes[j] = shapes[j+1];
                    shapes[j+1] = tmp;
                }
            }
        }
    }*/

    private void handleShow(boolean detailed) {
        // showDetail -> true, show -> false
        for (int i=0; i<n; i++) {
            System.out.println((i+1) + ", " + shapes[i].toString());
            if (detailed) {
                System.out.println("    The area is " + shapes[i].computeArea());
                System.out.println("    The perimeter is " + shapes[i].computePerimeter());
            }
        }
    }

    private void handleAdd() {
        String type = sc.next();
        switch (type) {
            case "R":
                int w = sc.nextInt();
                int h = sc.nextInt();
                addShape(new Rectangle(w, h));
                break;
            case "C":
                int r = sc.nextInt();
                addShape(new Circle(r));
                break;
            case "T":

        }
    }

    private void addShape(Shape shape) {
        shapes[n++] = shape;
    }

    public static void main(String[] args) {
        ShapeApplication app = new ShapeApplication();
        app.processCommand();
    }
}
