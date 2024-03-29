package Do_it_자료구조와_함께_배우는_알고리즘_입문_JAVA.chap06;

import java.util.Scanner;

public class MergeArray {
    // 배열 a, b를 병합한 최종 결과를 배열 c에 저장한다.
    static void merge(int[] a, int na, int[] b, int nb, int[] c) {
        // 각 배열에서의 현재 위치를 가리키는 인덱스 (커서)
        int pa = 0;
        int pb = 0;
        int pc = 0;

        // 1. 커서 pa, pb가 가리키는 값을 비교하고 더 작은 값을 c에 저장
        while(pa < na && pb < nb)
            c[pc++] = (a[pa] <= b[pb]) ? a[pa++] : b[pb++];

        // 2. 배열 b의 요소를 먼저 다 검사했다면 나머지 a는 그대로 c에 복사
        while(pa < na)
            c[pc++] = a[pa++];

        // 3. 배열 a의 요소를 먼저 다 검사했다면 나머지 b는 그대로 c에 복사
        while(pb < nb)
            c[pc++] = b[pb++];
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        int[] a = {2,4,6,8,11,13};
        int[] b = {1,2,3,4,9,16,21};
        int[] c = new int[13];

        System.out.println("두 배열의 병합");

        merge(a, a.length, b, b.length, c);

        System.out.println("배열 a와 b를 병합하여 배열 c에 저장했습니다.");
        System.out.println("배열 a : ");
        for(int i=0; i<a.length; i++)
            System.out.println("a[" + i + "] = " + a[i]);

        System.out.println("배열 b : ");
        for(int i=0; i<b.length; i++)
            System.out.println("b[" + i + "] = " + b[i]);

        System.out.println("배열 c : ");
        for(int i=0; i<c.length; i++)
            System.out.println("c[" + i + "] = " + c[i]);
    }
}
