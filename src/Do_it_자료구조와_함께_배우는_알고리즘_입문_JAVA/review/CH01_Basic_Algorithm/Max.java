package Do_it_자료구조와_함께_배우는_알고리즘_입문_JAVA.review.CH01_Basic_Algorithm;

import java.util.Scanner;

public class Max {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("세 정수의 최댓값을 구합니다.");
        System.out.println("a의 값: "); int a = stdIn.nextInt();
        System.out.println("b의 값: "); int b = stdIn.nextInt();
        System.out.println("c의 값: "); int c = stdIn.nextInt();

        // a, b, c 중 같은 숫자가 있더라도 올바르게 대소비교 가능
        int max = a;
        if (b > max) max = b;
        if (c > max) max = c;

        int max2 = max3(a,b,c);

        System.out.println("최댓값은 " + max + "입니다.");
        System.out.println("최댓값은 " + max2 + "입니다.");
    }


    // 최댓값을 구하는 기능을 하나의 메소드로 빼서 구현하는 것이 더 좋다.
    static int max3(int a, int b, int c) {
        int max = a;
        if (b > max) max = b;
        if (c > max) max = c;

        return max;
    }
}
