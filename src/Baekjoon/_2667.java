package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class _2667 {
    static int[][] house;
    static boolean[][] visited;

    static int N;
    static int cnt;   // 단지에 속하는 집의 개수 세기
    
    static ArrayList<Integer> arr = new ArrayList<>();   // 각 단지마다 존재하는 집의 수를 카운트하여 저장

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        house = new int[N][N];
        visited = new boolean[N][N];

        for (int i=0; i<N; i++) {
            String t = br.readLine();
            for (int j=0; j<t.length(); j++) 
                house[i][j] = t.charAt(j) - '0';   // 문자->정수로 치환
        }

        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                // 방문 조건 1. 아직 방문 X  2. 집이 존재 (house 배열의 원소 = ㄴ1)
                if (house[i][j] == 1 && visited[i][j] == false) {
                    cnt = 1;
                    dfs(i, j);
                    arr.add(cnt);   // 단지의 아파트 수 넣기
                }
            }
        }

        System.out.println(arr.size());  // 단지의 개수
        Collections.sort(arr);   // 아파트 수 오름차순으로 정렬
        for (int i=0; i<arr.size(); i++) {
            System.out.println(arr.get(i));
        }
    }

    static void dfs(int i, int j) {
        visited[i][j] = true;

        // 상하좌우로 집이 존재하는지 체크 
        // 방문 조건 1. 방문을 아직 하지 않은 인덱스  2. 집으로 표시된(1) 인덱스
        
        // 상
        if (i > 0 && house[i-1][j] == 1 && visited[i-1][j] == false) {
            cnt++;
            dfs(i-1, j);
        }

        // 하
        if (i < N-1 && house[i+1][j] == 1 && visited[i+1][j] == false) {
            cnt++;
            dfs(i+1, j);
        }

        // 좌
        if (j > 0 && house[i][j-1] == 1 && visited[i][j-1] == false) {
            cnt++;
            dfs(i, j-1);
        }

        // 우
        if (j < N-1 && house[i][j+1] == 1 && visited[i][j+1] == false) {
            cnt++;
            dfs(i, j+1);
        }
    }
}
