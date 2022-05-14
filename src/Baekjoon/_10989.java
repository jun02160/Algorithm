package Baekjoon;

import java.io.*;

public class _10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for(int i=0; i<N; i++)
            arr[i] = Integer.parseInt(br.readLine());

        quickSort(arr, 0, N-1);

        for(int num : arr)
            bw.write(num + "\n");

        bw.close();


    }

    // 배열 요소 a[idx1]과 a[idx2]의 값을 바꾸는 메소드
    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    static void quickSort(int[] arr, int left, int right) {
        int pl = left;      // 왼쪽 커서
        int pr = right;    // 오른쪽 커서
        int x = arr[(pl+pr)/2];   // 피벗

        do {
            while(arr[pl] < x) pl++;
            while(arr[pr] > x) pr--;
            if (pl <= pr)
                swap(arr, pl++, pr--);
        } while(pl <= pr);


        if(left < pr) quickSort(arr, left, pr);
        if(pl < right) quickSort(arr, pl, right);

    }

}
