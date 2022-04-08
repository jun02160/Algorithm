package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _11931_2 {

    static void swap_b(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
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

        for(int i=N-1; i>0; i--) {
            for(int j=0; j<i; j++) {
                if(arr[j] < arr[j+1]) {
                    swap_b(arr, j, j+1);
                }
            }
        }

        printList(arr);
    }
}
