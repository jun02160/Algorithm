package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _2504_2 {
    static Stack<Character> stack = new Stack<>();
    static String line;
    static int mul = 1;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        line = br.readLine();

        for (int i=0; i<line.length(); i++) {
            isClose(i);
        }


        System.out.println(stack.isEmpty() ? result : 0);
    }

    private static void isClose(int idx) {

        switch (line.charAt(idx)) {
            case '(':
                stack.push('(');
                mul *= 2;
                break;

            case '[':
                stack.push('[');
                mul *= 3;
                break;

            case ')':
                if (stack.isEmpty() || stack.peek() != '(') {
                    result = 0;
                    break;
                }

                if (line.charAt(idx-1) == '(') {
                    result += mul;
                }
                stack.pop();
                mul /= 2;
                break;

            case ']':
                if (stack.isEmpty() || stack.peek() != '[') {
                    result = 0;
                    break;
                }
                if (line.charAt(idx-1) == '[') {
                    result += mul;
                }
                stack.pop();
                mul /= 3;
                break;
        }

    }

}
