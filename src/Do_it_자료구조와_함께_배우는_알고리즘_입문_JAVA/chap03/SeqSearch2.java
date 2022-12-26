package Do_it_자료구조와_함께_배우는_알고리즘_입문_JAVA.chap03;

import java.util.Scanner;

public class SeqSearch2 {

    // for문으로 구현한 선형 탐색
    static int seqSearch(int[] arr, int n, int key) {
        for (int i=0; i<n; i++)
            if (arr[i] == key) return i;   // 종료 조건 1. 검색할 값과 같은 요소 발견 (해당 index 반환)

        return -1;  // 종료 조건 2. 검색 실패 (배열의 끝까지 탐색한 후에도 값 발견 X)
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
