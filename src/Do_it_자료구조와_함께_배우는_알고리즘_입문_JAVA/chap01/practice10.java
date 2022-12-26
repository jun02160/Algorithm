package Do_it_자료구조와_함께_배우는_알고리즘_입문_JAVA.chap01;

import java.util.Scanner;

public class practice10 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a;
        int b;

        System.out.print("a의 값: ");
        a = input.nextInt();

        while(true) {
            System.out.print("b의 값: ");
            b = input.nextInt();

            if(b > a) break;
            System.out.println("a보다 큰 값을 입력하세요!");
        }


        System.out.println("b - a는 " + (b - a) + "입니다");


    }
}
