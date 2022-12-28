package inflearn_Java로_배우는_자료구조.제2장;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RectCode {
    //TODO 왜 main함수가 포함된 데이터 멤버들만 static으로 선언해야 할까?
    static MyRectangle[] rects;
    static int n = 0;

    public static void main(String[] args) {
        // 객체 생성 총 3번 필요
        rects = new MyRectangle[100];
        try {
            Scanner in = new Scanner(new File("./input.txt"));
            while (in.hasNext()) {
                rects[n] = new MyRectangle();
                rects[n].lu = new MyPoint();

                rects[n].lu.x = in.nextInt();
                rects[n].lu.y = in.nextInt();
                rects[n].width = in.nextInt();
                rects[n++].height = in.nextInt();
            }

            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("No Data File.");
            System.exit(1);
        }

        bubbleSort();

        for (int i=0; i<n; i++) {
            System.out.println(rects[i].lu.x + " " + rects[i].lu.y + " " + rects[i].width + " " + rects[i].height);
        }
    }

    private static void bubbleSort() {
        for (int i=n-1; i>0; i--) {
            for (int j=0; j<i; j++) {
                if (calcArea(rects[j]) > calcArea(rects[j+1])) {
                    MyRectangle tmp = rects[j];
                    rects[j] = rects[j+1];
                    rects[j+1] = tmp;
                }
            }
        }
    }

    private static int calcArea(MyRectangle rect) {
        return rect.width * rect.height;
    }


}
