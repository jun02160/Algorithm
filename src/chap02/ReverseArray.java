package chap02;

import java.util.Scanner;

public class ReverseArray {

    static void swap(int[] arr, int idx1, int idx2) {
        int t = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = t;
    }

    static void reverse(int[] arr) {
        for (int i=0; i<arr.length / 2; i++) {
            printArr(arr.length, arr);
            int last = arr.length-i-1;
            System.out.println("arr[" + i + "]과(와) a[" + last + "]를 교환합니다.\n");
            swap(arr, i, last);
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("요솟수 : ");
        int num = stdIn.nextInt();

        int[] x = new int[num];

        for (int i=0; i<num; i++) {
            System.out.print("x[" + i + "] : ");
            x[i] = stdIn.nextInt();
        }

        reverse(x);

        System.out.println("\n\n요소를 역순으로 정렬했습니다.");
        printArr(num, x);
    }

    private static void printArr(int num, int[] x) {
        for (int i = 0; i< num; i++) {
            System.out.println("x[" + i + "] = " + x[i]);
        }
        System.out.println("\n\n");
    }
}
