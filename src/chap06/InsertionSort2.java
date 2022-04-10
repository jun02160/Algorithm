package chap06;

import java.util.Scanner;

public class InsertionSort2 {
    static void printAll(int[] arr) {
        for(int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    static void printState(int[] arr, int idx, int min) {
        for (int i = 0; i < arr.length; i++) {
            if(i == idx)
                System.out.print("*" + " ");
            else if(i == min)
                System.out.print("+" + " ");
            else
                System.out.print("  ");

        }
        System.out.println();
    }

    static int minIdx(int[] arr, int idx) {
        int min = idx;
        for(int i=idx; i<arr.length; i++) {
            if(arr[min] < arr[i])
                min = i;
        }

        return min;
    }

    static void insertionSort(int[] arr, int N) {

        for(int i=2; i<N; i++) {
            /* 차례인 i번째 이후 최솟값의 위치 찾기 */
            int min = minIdx(arr, i);

            /* 선택 정렬(배열의 머리요소는 비어 있는 상태 */
            int temp = arr[0] = arr[i];
            int j = i;
            for(; arr[j-1]>temp; j--)
                arr[j] = arr[j-1];
            if(j>0)     arr[j] = temp;


            printState(arr, i, min);
            printAll(arr);
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("단순 삽입 정렬");
        System.out.print("요소의 개수: ");
        int cnt = stdIn.nextInt();
        int[] x = new int[cnt+1];

        for(int i=1; i<=cnt; i++) {
            System.out.print("x["+i+"]: ");
            x[i] = stdIn.nextInt();
        }

        insertionSort(x, cnt);

        System.out.println("\n\n오름차순으로 정렬했습니다.");
        for(int i=1; i<=cnt; i++) {
            System.out.println("x[" + i + "]=" + x[i]);
        }

    }
}
