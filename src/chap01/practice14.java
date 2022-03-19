package chap01;

import java.util.Scanner;

public class practice14 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();

        System.out.println("----- 정사각형 모양 출력 -----");
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                System.out.print('*');
            }
            System.out.println();
        }

        System.out.println("\n\n----- 직각삼각형 모양 출력 -----");

        for(int i=1; i<=N; i++) {
            for(int j=1; j<=i; j++) {
                System.out.print('*');
            }
            System.out.println();
        }
    }
}
