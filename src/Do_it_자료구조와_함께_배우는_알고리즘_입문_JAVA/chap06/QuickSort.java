package Do_it_자료구조와_함께_배우는_알고리즘_입문_JAVA.chap06;

import java.util.Scanner;

public class QuickSort {
    // 배열 요소 a[idx1]과 a[idx2]의 값을 바꾸는 메소드
    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }


    // 배열을 나누는 메소드
    static void quickSort(int[] a, int left, int right) {
        int pl = left;     // 왼쪽 커서
        int pr = right;   // 오른쪽 커서
        int x = a[(pl+pr)/2];  // 피벗(가운데 위치의 값

        do {
            while(a[pl] < x) pl++;
            while(a[pr] > x) pr--;
            if (pl <= pr)
                swap(a, pl++, pr--);
        } while(pl <= pr);


        System.out.println("피벗의 값은 " + x + "입니다.");

        // a[0] ~ a[pl-1]
        System.out.println("피벗 이하의 그룹");
        for(int i=0; i<=pl-1; i++)
            System.out.print(a[i] + " ");
        System.out.println();

        // a[pr+1] ~ a[pl-1]
        if (pl > pr+1) {
            System.out.println("피벗과 일치하는 그룹");
            for(int i=pr+1; i<=pl-1; i++)
                System.out.print(a[i] + " ");
            System.out.println();
        }

        // a[pr+1] ~ a[n-1]
        System.out.println("피벗 이상의 그룹");
        for(int i=pr+1; i<right; i++)
            System.out.print(a[i] + " ");
        System.out.println();

        if(left < pr) quickSort(a, left, pr);
        if(pl < right) quickSort(a, pl, right);
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("퀵 정렬");
        System.out.print("요솟수 : ");
        int nx = stdIn.nextInt();
        int[] x = new int[nx];

        for(int i=0; i<nx; i++) {
            System.out.print("x[" + i + "]:");
            x[i] = stdIn.nextInt();
        }

        quickSort(x, 0, nx-1);

        System.out.println("오름차순으로 정렬했습니다.");
        for(int i=0; i<nx; i++)
            System.out.println("x[" + i + "]= " + x[i]);

    }
}
