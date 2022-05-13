package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _2751_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for(int i=0; i<N; i++)
            arr[i] = Integer.parseInt(br.readLine());

        // 오른쪽 아래에 위치한 서브트리부터 힘 정렬(마지막 인덱스)
        for(int i=(N-1)/2; i>=0; i--)
            heapSort(arr, i, N);

        // 아직 정렬되지 않은 부분 전체 트리에 대한 힙 정렬
        for(int i=N-1; i>0; i--) {
            swap(arr, 0, i);
            heapSort(arr, 0, i);
        }

        for(int num : arr)
            sb.append(num).append("\n");
        System.out.println(sb);
    }

    static void swap(int[] arr, int idx1, int idx2) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }

    public static void heapSort(int[] arr, int i, int N) {
        int cl = i*2 + 1;
        int cr = cl + 1;
        int root = i;

        if (cl < N && arr[cl] > arr[root])
            root = cl;
        if (cr < N && arr[cr] > arr[root])
            root = cr;

        if (root != i) {
            swap(arr, i, root);
            heapSort(arr, root, N);
        }
    }

}
