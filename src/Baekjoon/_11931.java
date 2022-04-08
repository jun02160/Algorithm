package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _11931 {
    static void swap(int[] arr, int max, int i) {
        int temp = arr[i];
        arr[i] = arr[max];
        arr[max] = temp;
    }

    static void printList(int[] arr) {
        for(int num : arr) {
            System.out.println(num);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for(int i=0; i<N-1; i++) {
            int max = i;
            for(int j=i; j<N; j++) {
                if(arr[j] > arr[max]) {
                    max = j;
                }
            }
            swap(arr, max, i);

        }

        printList(arr);
    }
}
