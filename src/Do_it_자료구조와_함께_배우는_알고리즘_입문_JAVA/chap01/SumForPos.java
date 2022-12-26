package Do_it_자료구조와_함께_배우는_알고리즘_입문_JAVA.chap01;

import java.util.Scanner;

public class SumForPos {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n;

        // do-while로 입력 시 예외처리하기
        do {
            System.out.print("n의 값: ");
            n = input.nextInt();
        } while (n <= 0);

        int sum = 0;

        for(int i=1; i<=n; i++)
            sum += i;

        System.out.println("1부터 " + n + "까지의 합은 " + sum + "입니다.");
    }
}
