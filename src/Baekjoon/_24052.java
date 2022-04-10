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

    static boolean insertSort(int[] arr, int K) {
        int count = 0;

        for(int i=1; i<arr.length; i++) {

            int j;
            int temp = arr[i];
            for(j=i; j>0&&arr[j-1]>temp; j--) {
                arr[j] = arr[j-1];
                count++;

                if(count==K) {
                    return true;
                }
            }


            if(j != i) {   // 기존의 자기 위치가 아닐 때만 삽입
                arr[j] = temp;
                count++;
                if(count==K) {
                    return true;
                }
            }
        }

        return false;

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

        if(insertSort(arr, K))
            printList(arr);
        else
            System.out.println("-1");
    }
}
