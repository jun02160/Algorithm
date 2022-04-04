package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2750 {

    static void swap(int[] arr, int num, int min) {
        int temp = arr[min];
        arr[min] = arr[num];
        arr[num] = temp;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        // 입력
        for(int i=0; i<N; i++)
            arr[i] = Integer.parseInt(br.readLine());

        // 정렬
        for(int i=0; i<N-1; i++) {
            int min = i;
            for(int j=i; j<N; j++) {
                if(arr[j] < arr[min])
                    min = j;   // 최솟값의 인덱스 저장
            }
            swap(arr, i, min); // 인덱스를 넘겨 swap
        }

        // 출력
        for(int num : arr) {
            System.out.println(num);
        }
    }
}
