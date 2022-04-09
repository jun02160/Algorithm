package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _24052 {

    static void printList(int[] arr) {
        for(int num : arr) {
            System.out.print(num+" ");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[A];

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<A; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<A; i++) {
            int temp = arr[i];

            int j;
            for(j=i; j>0&&arr[j-1]>temp; j--) {
                arr[j] = arr[j-1];
            }
            arr[j] = temp;
        }

        printList(arr);
    }
}
