package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _17425 {

    final static int MAX = 1000001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        long[] fx = new long[MAX];   // f(x) : 각 자연수의 모든 약수를 더한 값 저장
        long[] gx = new long[MAX];   // g(x) : 해당 자연수 이하의 모든 f(x)값을 더한 값 저장

        Arrays.fill(fx, 1);   // 모든 자연수는 1을 약수로 가지므로 1로 채워준다.

        for (int i=2; i<MAX; i++) {
            for (int j=1; i*j<MAX; j++) {  // i*j의 약수 x에 대하여 범위는 i*j (곱이 최대 약수)으로 제한
                fx[i*j] += i;
            }
        }

        for (int i=1; i<MAX; i++) {
            gx[i] = gx[i-1] + fx[i];   // f(x)을 차례로 더하여 (x 이하의 값에서의 약수 합) g(x) 계산
        }

        int T = Integer.parseInt(br.readLine());

        for (int i=0; i<T; i++) {
            sb.append(gx[Integer.parseInt(br.readLine())] + "\n");
        }
        System.out.println(sb);
    }

}
