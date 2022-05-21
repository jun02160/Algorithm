package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _15829 {
    static final long MOD = 1234567891;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 값 입력
        int L = Integer.parseInt(br.readLine());
        String str = br.readLine();
        
        long sum = 0;  // 총합
        long pow = 1;  // 거듭제곱
        
        char[] str_arr = str.toCharArray();
        for(int i=0; i<L; i++) {
            sum += (str_arr[i] - 'a' + 1) * pow % MOD;
            pow = pow * 31 % MOD;
        }

        long hash = sum % MOD;
        System.out.println(hash);
    }
}
