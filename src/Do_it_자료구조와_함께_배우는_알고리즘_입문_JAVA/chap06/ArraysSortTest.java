package Do_it_자료구조와_함께_배우는_알고리즘_입문_JAVA.chap06;

import java.util.Arrays;
import java.util.Scanner;

/* 기본 자료형 배열의 정렬 => 퀵 정렬 */
public class ArraysSortTest {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("요솟수: ");
        int num = stdIn.nextInt();
        int[] x = new int[num];

        for(int i=0; i<num; i++) {
            System.out.print("x[" + i + "]: ");
            x[i] = stdIn.nextInt();
        }

        Arrays.sort(x);   // 퀵 정렬 알고리즘을 이용한 정렬 메소드

        System.out.println("오름차순으로 정렬했습니다. ");
        for(int i=0; i<num; i++)
            System.out.println("x[" + i + "] = " + x[i]);
    }
}
