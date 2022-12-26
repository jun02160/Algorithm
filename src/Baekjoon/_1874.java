package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int top = 0;
        int index = 0;
        int N = Integer.parseInt(br.readLine());

        int[] stack = new int[N];
        StringBuilder sb = new StringBuilder();

        for(int temp : stack) {
            int value = Integer.parseInt(br.readLine());

            if(value > top) {
                for(int i=top+1; i<=value; i++) {
                    stack[index++] = i;
                    sb.append("+\n");
                }
                top = value;
            } else if(stack[index-1] != value) {
                System.out.println("NO");
                return;
            }
            index--;  //pop의 효과
            sb.append("-\n");
        }
        System.out.println(sb);
    }
}
