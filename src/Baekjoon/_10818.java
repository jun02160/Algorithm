package Baekjoon;

import java.io.*;
import java.util.StringTokenizer;

import static java.util.Arrays.sort;

public class _10818 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        /**
         * Solution 1. 입력과 동시에 대소 비교
         */
        int max = -1000000;  // 제시된 범위에 따른 초기화
        int min = 1000000;

        for (int i=0; i<N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (max < num) max = num;
            if (min > num) min = num;
        }

        /*
         * Solution 2. 배열 정렬

        int[] arr = new int[N];
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        sort(arr);
        System.out.println(String.valueOf(arr[0]) + " " +  String.valueOf(arr[arr.length-1]));
        */

        bw.write(String.valueOf(min) + " " + String.valueOf(max));

        br.close();
        bw.close();
    }
}
