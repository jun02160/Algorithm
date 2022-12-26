package Do_it_자료구조와_함께_배우는_알고리즘_입문_JAVA.chap06;

import java.util.Scanner;

public class BubbleSort {
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

    static void printList2(int[] arr, int idx) {
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i]);

            if(i == idx) {
                if(arr[idx] > arr[idx+1])
                    System.out.print('+');
                else
                    System.out.print('-');
            } else {
                System.out.print(" ");
            }
        }
    }

    // 오른쪽부터 비교&교환한 버전 1
    static void bubbleSort(int[] arr, int N) {
        int swap_cnt = 0;
        int compare_cnt = 0;
        for(int i=0; i<N-1; i++) {
            System.out.println("패스" + (i+1) + ":");

            for(int j=N-1; j>i; j--) {   // i번째는 자동으로 정렬이 끝난 상태이므로 N-1 -> i+1번째까지 이웃한 원소를 swap 한다.
                printList(arr, j);

                if(arr[j-1] > arr[j]) {
                    swap(arr, j - 1, j);
                    swap_cnt++;
                }
                compare_cnt++;
                System.out.println();
            }
            System.out.println();
        }

        System.out.println("\n\n비교를 " + compare_cnt + "회 했습니다.");
        System.out.println("교환을 " + swap_cnt + "회 했습니다.\n\n");
    }

    // 왼쪽부터 비교&교환
    static void bubbleSort2(int[] arr, int N) {
        for(int i=0; i<N-1; i++) {
            System.out.println("패스" + (i+1) + ":");

            for(int j=i; j<N-1; j++) {   // i번째는 자동으로 정렬이 끝난 상태이므로 N-1 -> i+1번째까지 이웃한 원소를 swap 한다.

                if(arr[j] > arr[j+1]) {
                    printList2(arr, j);
                    swap(arr, j , j+1);
                } else {
                    printList2(arr, j);
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("버블 정렬(ver.1)");
        System.out.print("요소의 개수: ");
        int cnt = stdIn.nextInt();
        int[] x = new int[cnt];

        for(int i=0; i<cnt; i++) {
            System.out.print("x[" + i + "] : ");
            x[i] = stdIn.nextInt();
        }

        bubbleSort(x, cnt);

        System.out.println("오름차순으로 정렬했습니다.");
        for(int i=0; i<cnt; i++) {
            System.out.println("x[" + i + "] = " + x[i]);
        }
    }
}
