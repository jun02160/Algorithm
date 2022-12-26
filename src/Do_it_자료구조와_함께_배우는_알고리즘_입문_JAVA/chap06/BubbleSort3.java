package Do_it_자료구조와_함께_배우는_알고리즘_입문_JAVA.chap06;

import java.util.Scanner;

public class BubbleSort3 {
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

    // 더이상 교환 수행 X == 이미 정렬된 상태임을 이용한 버전3
    static void bubbleSort(int[] arr, int N) {
        int k=0;       // 정렬을 끝낸 인덱스의 위치 기준을 나타내는 변수
        int compare_cnt = 0;
        int swap_cnt = 0;

        while(k < N-1) {
            int last = N-1;   // 마지막으로 요소를 교환한 위치
            for(int j=N-1; j>k; j--) {
                printList(arr, j);
                if(arr[j-1] > arr[j]) {
                    System.out.println("\nswap 이전 last: " +last);
                    swap(arr, j-1, j);
                    swap_cnt++;
                    last = j;  // 정렬해야 할 대소 비교에서만 last를 갱신함
                    System.out.println("swap 이후 last: " +last);
                }
                compare_cnt++;
                System.out.println();
            }
            System.out.println();
            k = last;  // 다음 수행할 패스의 범위 제한
            System.out.println("k와 N-1의 값: " + k + ", " + (N-1) + "\n");
        }
        System.out.println("\n\n비교를 " + compare_cnt + "회 했습니다.");
        System.out.println("교환을 " + swap_cnt + "회 했습니다.\n\n");
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("버블 정렬(ver.3)");
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
