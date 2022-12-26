package Do_it_자료구조와_함께_배우는_알고리즘_입문_JAVA.chap05;

import java.util.Scanner;

public class Factorial {

    static int factorial(int n) {
        if (n > 0)
            return n * factorial(n-1);
        else
            return 1;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("정수를 입력하세요 : ");
        int x = stdIn.nextInt();

        System.out.println(x + "의 팩토리얼은 " + factorial(x) + "입니다.");
    }
}
