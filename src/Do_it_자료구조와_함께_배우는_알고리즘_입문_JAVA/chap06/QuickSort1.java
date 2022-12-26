package Do_it_자료구조와_함께_배우는_알고리즘_입문_JAVA.chap06;

import java.util.Scanner;

public class QuickSort1 {

    // 배열 요소 a[idx1]과 a[idx2]의 값을 바꾸는 메소드
    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }


    static void quickSort(int[] arr, int left, int right) {
        int pl = left;
        int pr = right;
        int x = arr[(pl+pr)/2];

        System.out.printf("a[%d]~a[%d] : {", left, right);
        for (int i=left; i<right; i++)
            System.out.printf("%d , ", arr[i]);
        System.out.printf("%d}\n", arr[right]);


        do {
            // 피벗을 기준으로 왼쪽 요소 정렬
            while (arr[pl] < x) pl++;
            while (arr[pr] > x) pr--;

            if(pl <= pr)
                swap(arr, pl++, pr--);
        } while (pl <= pr);

        if(left < pr) quickSort(arr, left, pr);
        if(pl > right) quickSort(arr, pl, right);
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
