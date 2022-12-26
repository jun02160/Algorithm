package Do_it_자료구조와_함께_배우는_알고리즘_입문_JAVA.chap02;

import java.util.Scanner;

public class CardConvRev {
    // 정수 x를 r진수로 변환하여 배열 d에 아랫자리부터 넣어두고 자릿수를 반환하는 메소드
    static int cardConvR(int x, int r, char[] d) {
        int digits = 0;
        String dchar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int flag = 0;

        do {
            d[digits++] = dchar.charAt(x % r);
            if (flag == 1) {
                System.out.printf("%2d | \t%2d ```%2d\n", r, x, x%r);
            } else {
                System.out.printf("%2d | \t%2d\n", r, x);
            }
            System.out.println("   + ----------");
            x /= r;
            flag = 1;
        } while (x != 0);
        return digits;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        int no;   // 변환할 정수
        int cd;   // 기수
        int dno;  // 변환 후의 자릿수
        int retry;
        char[] cno = new char[32];   // 변환 후 각 자릿수를 넣어두는 문자 배열

        System.out.println("10진수를 기수 변환합니다.");
        do {
            do {
                System.out.print("변환하는 음이 아닌 정수 : ");
                no = stdIn.nextInt();
            } while (no < 0);

            do {
                System.out.print("어떤 진수로 변환할까요? (2~36) : ");
                cd = stdIn.nextInt();
            } while (cd < 2 || cd > 36);

            dno = cardConvR(no, cd, cno);

            System.out.print(cd + "진수로는 ");
            for (int i=dno-1; i>=0; i--)
                System.out.print(cno[i]);
            System.out.println("입니다.");

            System.out.print("한 번 더 할까요? (1.예 / 0.아니오) : ");
            retry = stdIn.nextInt();
        } while (retry == 1);

    }
}
