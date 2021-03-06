package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2751 {
    static int[] buff;
    static int n = 1;

    static void __mergeSort(int[] a, int left, int right) {
        if (left < right) {
            int i;
            int center = (left + right) / 2;
            int p = 0;
            int j = 0;
            int k = left;


            __mergeSort(a, left, center);
            __mergeSort(a, center+1, right);

            System.out.println(n+"회 " + "부분 집합의 병합 정렬");
            for(i=0; i<right+1; i++) {
                System.out.println("a[" + i + "]=" + a[i]);
            }
            System.out.println();
            n++;

            for (i=left; i<=center; i++)
                buff[p++] = a[i];
            while (i <= right && j < p)
                a[k++] = (buff[j] <= a[i]) ? buff[j++] : a[i++];
            while (j < p)
                a[k++] = buff[j++];
        }
    }

    static void mergeSort(int[] a, int n) {
        buff = new int[n];

        __mergeSort(a, 0, n-1);

        buff = null;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for(int i=0; i<N; i++)
            arr[i] = Integer.parseInt(br.readLine());

        mergeSort(arr, N);

        for(int i=0; i<N; i++)
            System.out.println(arr[i]);
    }
}
