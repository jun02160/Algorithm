package chap06;

import java.util.Scanner;

public class BubbleSort2 {

    static void swap(int[] arr, int idx1, int idx2) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }

    static void printList(int[] arr, int idx) {
        for(int i=0; i<arr.length; i++) {

            if(i == idx) {
                if(arr[idx-1] > arr[idx])
                    System.out.print('+');
                else
                    System.out.print('-');
            } else {
                System.out.print(" ");
            }
            System.out.print(arr[i]);

        }
    }

    // 멈춤으로 복잡도를 개선한 버전 2
    static void bubbleSort(int[] arr, int N) {
        int swap_cnt = 0;
        int compare_cnt = 0;
        for (int i = 0; i < N - 1; i++) {
            System.out.println("패스" + (i+1) + ":");

            int exchg = 0;
            for (int j = N - 1; j > i; j--) {
                printList(arr, j);

                if(arr[j-1] > arr[j]) {
                    swap(arr, j-1, j);
                    swap_cnt++;
                    exchg++;   // 패스마다 교환횟수 기록
                }
                if(exchg == 0) break;;  // 교환한 부분이 없다면 바로 다음 패스로 건너뛰기
                compare_cnt++;
                System.out.println();
            }
            System.out.println();
        }
        System.out.println("\n\n비교를 " + compare_cnt + "회 했습니다.");
        System.out.println("교환을 " + swap_cnt + "회 했습니다.\n\n");
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("버블 정렬(ver.2)");
        System.out.print("요소의 개수: ");
        int cnt = stdIn.nextInt();
        int[] x = new int[cnt];

        for (int i = 0; i < cnt; i++) {
            System.out.print("x[" + i + "] : ");
            x[i] = stdIn.nextInt();
        }

        bubbleSort(x, cnt);

        System.out.println("오름차순으로 정렬했습니다.");
        for (int i = 0; i < cnt; i++) {
            System.out.println("x[" + i + "] = " + x[i]);
        }
    }
}
