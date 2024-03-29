package Do_it_자료구조와_함께_배우는_알고리즘_입문_JAVA.chap04;

import java.util.Scanner;

// 오래된 데이터를 버리는 용도의 링 버퍼 사용
public class LastNElements {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        final int N = 10;
        int[] a = new int[N];
        int cnt = 0;
        int retry;

        System.out.println("정수를 입력하세요.");

        do {
            System.out.printf("%d번째 정수 : ", cnt+1);
            a[cnt++ % N] = stdIn.nextInt();   // 입력한 값을 저장하는 위치의 인덱스 -> 나머지 연산자 이용

            System.out.print("계속 할까요? (예.1/아니오.0) :");
            retry = stdIn.nextInt();
        } while (retry == 1);

        int i = cnt - N;
        if(i<0) i=0;

        for(; i<cnt; i++)
            System.out.printf("%2d번째의 정수 = %d\n", i+1, a[i%N]);
    }
}
