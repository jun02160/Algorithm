package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _11723 {

    public static List<Integer> sets = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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

    }

    public static void myRemove(int x) {
        int idx = sets.indexOf(x);
        if (idx == -1) return;
        else {
            for (int i=0; i<sets.size(); i++) {
                if (i == idx) sets.remove(i); break;
            }
        }
    }

    public static void commands(String cmd) {
        switch (cmd) {
            case "all":
                int len = sets.size();
                for (int i=0; i<len; i++) {
                    sets.set(i, i+1);
                }
                for (int i=len; i<=20; i++) {
                    sets.add(i);
                }
                break;
            case "empty":
                sets.clear();
                break;
        }
    }

    public static void commands(String cmd, int x) {
        switch (cmd) {
            case "add":
                if (sets.isEmpty()) sets.add(x);
                else if (!sets.contains(x)) sets.add(x);
                break;
            case "remove":
                myRemove(x);
                break;
            case "check":
                if (sets.contains(x)) System.out.println(1);
                else System.out.println(0);
                break;
            case "toggle":
                if (sets.contains(x)) {
                    myRemove(x);
                }
                else sets.add(x);
                break;
        }
    }
}
