package Baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class _11723 {

    static StringBuilder sb = new StringBuilder();
    static int bitMask = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            if (cmd.equals("empty") || cmd.equals("all")) {
                commands(cmd);
                continue;
            }

            int x = Integer.parseInt(st.nextToken());
            commands(cmd, x);
        }

        bw.write(sb.toString());
        bw.close();
        br.close();

    }

    public static void commands(String cmd) {
        switch (cmd) {
            case "all":
                bitMask = ~0;  // 1~20의 모든 비트를 1로 켜준다,
                break;
            case "empty":
                bitMask = 0;  // 1~20의 모든 비트를 0으로 끈다,
                break;
        }
    }

    public static void commands(String cmd, int x) {
        switch (cmd) {
            case "add":   // ex. add 1, add 2, add 3 의 결과는 -> 111
                bitMask = bitMask | 1 << (x-1); // 1 << (x-1): x-1번 비트만 1, 나머지 비트는 0으로 만들고 | 연산으로 나머지는 원래 상태를 유지한 채 x-1번 비트를 1로 바꿔준다,
                break;
            case "remove":
                bitMask = bitMask & ~(1 << (x-1)); // 1 << (x-1): 추가 시와 동일하기 x-1번 비트를 1로 만들어주고, & 연산을 진행하여 x-1번만 0으로 바뀌고 나머지는 유지되도록 한다.
                break;
            case "check":
                sb.append(((bitMask & 1 << (x-1)) == 1 << (x-1) ? 1 : 0) + "\n");
                break;
            case "toggle":
                bitMask = bitMask ^ 1 << (x-1);  // ^ 연산을 통해 x-1번 자리의 비트를 1->0. 0->1로 바꿔준다.
                break;
        }
    }
}
