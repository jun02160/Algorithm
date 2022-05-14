package Baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<N; i++)
            arr[i] = Integer.parseInt(st.nextToken());


        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());


        // 이진 탐색을 하려면 정렬이 우선!
        Arrays.sort(arr);

        st = new StringTokenizer(br.readLine(), " ");

        for (int i=0; i<M; i++) {
            int is_num = binSearch(arr, N, Integer.parseInt(st.nextToken()));
            bw.write(is_num+"\n");
        }

        bw.close();

    }

    static int binSearch(int[] arr, int n, int key) {
        int pl = 0;
        int pr = n-1;

        while (pl <= pr) {
            int pc = (pl+pr)/2;  // 중간값 구하기

            // key값이 중간값보다 작은 경우
            if (key < arr[pc])
                pr = pc-1;

            // key값이 중간값보다 큰 경우
            else if (key > arr[pc])
                pl = pc+1;

            // 검색에 성공한 경우 -> 1 반환
            else
                return 1;

        }

        return 0;
    }
}
