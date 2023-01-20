package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;

public class _2504 {
    static Stack<Character> stack = new Stack<>();
    static String line;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int result = 0;
        int tmp = 1;

        line = br.readLine();

        stack.add(line.charAt(0));
        for (int i=1; i<line.length(); i++) {
            int temp = isClose(line.charAt(i));  // 괄호 쌍을 찾으면 -1이 아닌 값을 가짐


            if (temp != -1) {
                if (!stack.isEmpty()) {
                    if (isNextValue(i)) {
                        tmp *= temp;
                    } else if (!isNextValue(i)) {
                        if (tmp == 1) {
                            result += temp;
                        } else {
                            if (result == 0) {
                                result += tmp;
                            } else {
                                result *= tmp;
                            }
                        }
                    }
                } else {
                    if (i == line.length()-1) {
                        tmp *= temp;
                        if (tmp != 1) result += tmp;
                        break;
                    }
                    if (tmp != 1) result += tmp;
                    result *= temp;
                    tmp = 1;
                }

                //



                /*if (isNextValue(i)){
                    tmp *= temp;
                } else if (!isNextValue(i) && stack.isEmpty())  {
                    result += tmp;
                    tmp = 1;
                } else if (!isNextValue(i)) {
                    result += temp;
                }  else {
                    tmp *= temp;
                    result += tmp;
                    tmp = 1;
                }*/
            }

            System.out.println(stack.toString() + "   result, temp, tmp = " + result + ", " + temp + ", " + tmp);

        }


        System.out.println(stack.isEmpty() ? result : 0);
    }

    private static int isClose(char c) {
        char curr = 0;
        if (!stack.isEmpty())
            curr = (char) stack.peek();
        switch (c) {
            case ')':
                if (curr == '(') {
                    stack.pop();
                    return 2;
                }
                break;
            case ']':
                if (curr == '[') {
                    stack.pop();
                    return 3;
                }
                break;
        }
        if (c == '(' || c == '[')
            stack.add(c);

        return -1;
    }

    /**
     * @return
     * 열린 괄호 뒤에 열린 괄호 / 닫힌 괄호 뒤에 닫힌 괄호 : true
     * 이외: false
     */
    private static boolean isNextValue(int i) {
        if (i == line.length()-1) return false;

        if (line.charAt(i) == ')' || line.charAt(i) == ']') {
            return line.charAt(i + 1) == ')' || line.charAt(i + 1) == ']';
        } else if (line.charAt(i) == '(' || line.charAt(i) == '[') {
            return line.charAt(i + 1) == '(' || line.charAt(i + 1) == '[';
        }
        return false;
    }
}
