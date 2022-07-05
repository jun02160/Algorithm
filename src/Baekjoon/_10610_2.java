package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

public class _10610_2 {
    static ArrayList<Integer> result = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String num_str = br.readLine();   // 120
        char[] char_arr = num_str.toCharArray();   // {1, 2, 0}
        int[] num_arr = new int[char_arr.length];
        for(int i=0; i<char_arr.length; i++)
            num_arr[i] = Integer.parseInt(String.valueOf(char_arr[i]));

        permutation(num_arr, 0, num_str.length(), num_str.length());
        result.sort(Comparator.reverseOrder());   // 가장 큰 수를 구하는 것이므로 내림차순 정렬

        for(int i=0; i<result.size(); i++) {
            if (result.get(i) >= Integer.parseInt(num_str) && result.get(i) % 30 == 0) {
                System.out.println(result.get(i));
                return;
            }
        }

        System.out.println(-1);
    }

    // n개 중에 r개를 뽑는 순열 알고리즘
    static void permutation(int[] arr, int depth, int n, int r) {
        if (depth == r) {
            toNum(arr, r);
            //print_arr(arr, r);
            return;
        }

        for (int i=depth; i<n; i++) {
            swap(arr, depth, i);
            permutation(arr, depth+1, n, r);
            swap(arr, depth, i);
        }
    }

    static void swap(int[] arr, int n, int i) {
        int temp = arr[n];
        arr[n] = arr[i];
        arr[i] = temp;
    }

    /*static void print_arr(int[] arr, int r) {
        for (int i=0; i<r; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }*/

    static void toNum(int[] arr, int N) {
        int num = 0;
        int len = arr.length-1;
        for(int i=0; i<N; i++) {
            num += arr[i] * Math.pow(10, len--);
        }
        result.add(num);
    }
}
