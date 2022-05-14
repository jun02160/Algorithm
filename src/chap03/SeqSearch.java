package chap03;

import java.util.Scanner;

public class SeqSearch {

    // while 문으로 구현한 선형탐색
    static int seqSearch(int[] arr, int n, int key) {
        int i=0;

        while (true) {
            if (i == n) return -1;    // 검색 실패 (-1)
            if (arr[i] == key) return i;  // 검색 성공 (index)
            i++;
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("요솟수: ");
        int num = stdIn.nextInt();
        int[] x = new int[num];


        for (int i=0; i<num; i++) {
            System.out.print("x[" + i + "]: ");
            x[i] = stdIn.nextInt();
        }

        System.out.print("검색할 값: ");
        int key = stdIn.nextInt();

        int idx = seqSearch(x, num, key);

        if (idx == -1)
            System.out.println("그 값의 요소가 없습니다. 검색 실패!");
        else
            System.out.println(key + "은(는) x[" + idx + "]에 있습니다.");
    }
}
