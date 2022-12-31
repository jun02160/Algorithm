package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class _1676 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        BigInteger fact = factorial(num);
        int cnt = 0;
        System.out.println(fact);
        while (fact.compareTo(BigInteger.valueOf(0)) > 0) {
            System.out.println(fact);
            if (fact.remainder(BigInteger.valueOf(10)).equals(BigInteger.ZERO)) cnt++;
            else break;
            fact.divide(BigInteger.valueOf(10));
            System.out.println(fact);
        }
        System.out.println(cnt);

    }

    private static BigInteger factorial(int n) {
        BigInteger result = BigInteger.ONE;
        for (int i=1; i<=n; i++)
            result.multiply(BigInteger.valueOf(i));
        return result;
    }
}
