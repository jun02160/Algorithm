package chap01;

import java.util.Scanner;

public class practice11 {
    static int count_num(int num) {
        int count = 0;
        while (num > 0) {
            num /= 10;
            count++;
        }

        return count;
    }

    static int count_num2(int num) {
        String num_str = String.valueOf(num);
        int count = num_str.length();

        return count;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();

        System.out.println("그 수는 " + count_num(num) + "자리입니다");
        System.out.println("그 수는 " + count_num2(num) + "자리입니다");
    }


}
