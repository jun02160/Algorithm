package Do_it_자료구조와_함께_배우는_알고리즘_입문_JAVA.review.CH01_Basic_Algorithm;

import java.util.Scanner;

public class Sum {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("1부터 n까지의 합을 구합니다.");
        System.out.println("n의 값");
        int n = stdIn.nextInt();

        int sum = 0;
        int sum2 = 0;
        int i = 0;

        while (i<=n) {
            sum += i;
            i++;
        }

        for (i=1; i<=n; i++) {
            sum2 += i;;
        }
        System.out.println("1부터 " + n + "까지의 합은 " + sum + "입니다.");
        System.out.println("1부터 " + n + "까지의 합은 " + sum2 + "입니다.");
    }
}
