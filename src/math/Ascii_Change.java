package math;

import java.util.Scanner;

public class Ascii_Change {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //== 문자 -> 숫자 변환 ==//
        char alpha = sc.nextLine().charAt(0);
        int alpha_num = (int) alpha;

        System.out.println("입력 문자: " + alpha);
        System.out.println("숫자 변환 이후: " + alpha_num);


        //== 숫자 -> 문자 변환 ==//
        int num = sc.nextInt();
        char num_alpha = (char) num;
        System.out.println("입력 숫자: " + num);
        System.out.println("문자 변환 이후: " + num_alpha);

        String binaryInt = Integer.toBinaryString(10);
        String octalInt = Integer.toOctalString(10);
        String hexInt = Integer.toHexString(10);

        System.out.println(binaryInt);
        System.out.println(octalInt);
        System.out.println(hexInt);

        int binToDec = Integer.parseInt(binaryInt, 2);
        int octToDec = Integer.parseInt(octalInt, 8);
        int hexToDec = Integer.parseInt(hexInt, 16);

        System.out.println(binToDec);
        System.out.println(octToDec);
        System.out.println(hexToDec);

    }
}
