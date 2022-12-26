package Do_it_자료구조와_함께_배우는_알고리즘_입문_JAVA.chap02;

import java.util.Scanner;

public class ArrayEqual {
    
    static boolean equals(int[] a, int[] b) {
        // 1. 두 배열의 길이가 다르면 동일한 배열 X
        if (a.length != b.length)
            return false;
        
        // 2. 배열의 모든 요소를 traverse 하여 비교 과정 반복
        for (int i=0; i<a.length; i++) {
            if (a[i] != b[i])
                return false;
        }

        return true;   // 반복문을 중단하지 않왔다면 동일한 배열로 판단
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("배열 a의 요솟수: ");
        int na = stdIn.nextInt();

        int[] a = new int[na];

        for (int i=0; i<na; i++) {
            System.out.print("a[" + i + "] : ");
            a[i] = stdIn.nextInt();
        }

        System.out.print("배열 b의 요솟수: ");
        int nb = stdIn.nextInt();

        int[] b = new int[nb];

        for (int i=0; i<nb; i++) {
            System.out.print("b[" + i + "] : ");
            b[i] = stdIn.nextInt();
        }

        System.out.println("배열 a와 b는 " + (equals(a, b) ? "같습니다" : "같지 않습니다"));


    }
}
