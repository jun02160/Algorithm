package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

public class _11866 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        ArrayList<Integer> nums = new ArrayList<>();
        for (int i=1; i<=N; i++)  nums.add(i);

        Iterator<Integer> iter = nums.iterator();


        int curr = K;  // 현재 인덱스
        for (int i=0; i<K; i++) curr = iter.next();

        sb.append("<");
        int p = 1;
        while (nums.size() > 1) {
            printArr(nums);

            sb.append(curr).append(", ");
            iter.remove();
            iter = nums.iterator();
//            for (int i=0; i<curr-1; i++) iter.next();
            int tp = 0;
            while (tp < curr-p) {
                if (!iter.hasNext()) {
                    iter = nums.iterator();
                    iter.next();
                    tp++;
                    continue;
                }
                iter.next();
                tp++;
            }

            int tmp = 0;
            while (tmp < K) {
                if (!iter.hasNext()) {
                    iter = nums.iterator();
                    curr = iter.next();
                    tmp++;
                    System.out.println("curr: " + curr + ", tmp: "+ tmp);
                    continue;
                }
                curr = iter.next();
                tmp++;
                System.out.println("curr: " + curr + ", tmp: "+ tmp);
            }

            p++;

        }
        sb.append(nums.get(0)).append(">");
        System.out.println(sb);


    }


    private static void printArr(ArrayList<Integer> arr) {
        System.out.println("============");
        for (int num : arr) {
            System.out.println(num);
        }
        System.out.println("============");
    }
}
