package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2752 {

    static void swap(int[] arr, int idx1, int idx2) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }


    static void listSort(int[] arr) {
        for(int i=0; i<2; i++) {
            int min = i;

            for(int j=i+1; j<3; j++) {
                if(arr[j] < arr[min]) {
                    min = j;
                }
            }
            swap(arr, i, min);

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] num = new int[3];
        for(int i=0; i<3; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        listSort(num);

        for(int n : num)
            System.out.print(n + " ");

    }
}
