package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _16563 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());


        // 소수 배열 구성
        int max = 5_00_0000;
        int[] primes = new int[max+1];
        for (int i=2; i<=max; i++) primes[i] = i;

        for (int i=2; i<=max; i++) {
            if (primes[i] == 0) continue;

            for (int j=2*i; j<=max; j+=i) {
                primes[j] = 0;
            }
        }

        for (int j=0; j<N; j++) {
            int n = Integer.parseInt(st.nextToken());

            for (int i=0; n>1; i++) {
                if (primes[i] != 0) {
                    while (n % i == 0) {
                        sb.append(i).append(" ");
                        n /= i;
                    }
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }
}
