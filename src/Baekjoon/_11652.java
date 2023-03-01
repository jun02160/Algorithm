package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _11652 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int MAX = 100000;
        int[] nums = new int[N];
        for (int i=0; i<=MAX; i++) {
            nums[i] = 0;
        }
        for (int i=0; i<N; i++) {
            nums[Integer.parseInt(br.readLine())]++;
        }

        int maxIdx = 0;
        for (int i=0; i<=MAX; i++) {
            if (nums[i] > nums[maxIdx]) maxIdx = i;
        }
        System.out.println(maxIdx);

    }
}
