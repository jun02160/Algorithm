package Do_it_자료구조와_함께_배우는_알고리즘_입문_JAVA.chap03;

import java.util.Scanner;

public class BinSearch {

    // 요소의 개수가 n인 배열에서 key값을 가진 요소 이진 검색
    static int binSearch(int[] arr, int n, int key) {
        int pl = 0;    // 검색 범위의 첫 인덱스
        int pr = n-1;  // 검색 범위의 끝 인덱스

        do {
            int pc = (pl+pr)/2;
            
            // 검색에 성공한 경우
            if (arr[pc] == key)
                return pc;

            // key값이 중간값보다 큰 경우
            else if (arr[pc] < key)
                pl = pc+1;

            // key값이 중간값보다 작은 경우
            else
                pr = pc-1;
        } while (pl <= pr);

        
        return -1;  // 검색 실패
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("요솟수: ");
        int num = stdIn.nextInt();
        int[] x = new int[num];

        System.out.println("오름차순으로 입력하세요. ");  // 이미 정렬된 배열을 다루는 이진 탐색의 특징

        System.out.print("x[0]: ");
        x[0] = stdIn.nextInt();

        // 오름차순으로 입력되는지에 대한 예외 처리
        for (int i=1; i<num; i++) {
            do {
                System.out.print("x[" + i + "]: ");
                x[i] = stdIn.nextInt();
            } while (x[i] < x[i-1]);
        }

        System.out.print("검색할 값: ");
        int key = stdIn.nextInt();

        int idx = binSearch(x, num, key);

        if (idx == -1)
            System.out.println("그 값의 요소가 없습니다. 검색 실패!");
        else
            System.out.println(key + "은(는) x[" + idx + "]에 있습니다.");
    }
}
