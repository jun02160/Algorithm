package chap03;

import java.util.Scanner;

public class SeqSearch3 {
    // 보초법을 이용한 선형 검색 -> 비용 반으로 절감 : 미리 찾고자 하는 key 값(보초)을 배열에 저장해두는 방식
    static int seqSearchSen(int[] arr, int n, int key) {
        int i=0;

        arr[n] = key;

        // 종료 조건을 줄이는 방식으로 반복 종료의 판단 횟수를 반으로 줄임!
        while (true) {
            if (arr[i] == key)   break;  // 검색 성공
            i++;
        }
        return i == n ? -1 : i;  // 보초값이 위치한 인덱스가 저장된다면 결과적으로 검색에 실패한 것
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("요솟수: ");
        int num = stdIn.nextInt();
        int[] x = new int[num+1];


        for (int i=0; i<num; i++) {
            System.out.print("x[" + i + "]: ");
            x[i] = stdIn.nextInt();
        }

        System.out.print("검색할 값: ");
        int key = stdIn.nextInt();

        int idx = seqSearchSen(x, num, key);

        if (idx == -1)
            System.out.println("그 값의 요소가 없습니다. 검색 실패!");
        else
            System.out.println(key + "은(는) x[" + idx + "]에 있습니다.");
    }
}
