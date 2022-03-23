package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class _2346_2 {

    // 백준 2346 풍선 터뜨리기
    // SinglyLinkedList
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] balloon = new int[N];
        ArrayList<Integer> result = new ArrayList<>();
        for(int i=0; i<N; i++) {
            balloon[i] = Integer.parseInt(st.nextToken());
        }

        LinkedList<Integer> list = new LinkedList<>();
        for(int i=1; i<=N; i++) {
            list.add(i);
        }

        int index = 0;
        while(true) {
            int num = list.remove(index);
            result.add(num);

            if(list.isEmpty()) break;

            int move = balloon[num-1];
            if(move > 0) {  // 뽑은 수가 양수인 경우 -> 오른쪽 이동
                --index;
                index = (index+move) % list.size();  //노드 순회의 개념을 나머지 연산으로 접근
            } else {   // 뽑은 수가 음수인 경우 -> 왼쪽 이동 (절댓값으로 처리)
                move = Math.abs(move);
                move = list.size() - (move % list.size());
                index = (index + move) % list.size();
            }
        }
        for(int num : result) {
            System.out.print(num + " ");
        }
    }
}

