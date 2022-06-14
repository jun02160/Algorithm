package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _2178 {
    static int N, M;

    static int[][] dist;  // 이동 방향과 횟수 기록
    static int[][] maze;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        maze = new int[N][M];
        dist = new int[N][M];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for (int j=0; j<M; j++) {
                maze[i][j] = str.charAt(j) - '0';  // 문자 -> 정수로 치환
            }
        }

        for (int i=0; i<N; i++) {
            Arrays.fill(dist[i], -1);  // 배열 -1로 초기화
        }

        bfs(0,0);
        // 실제 미로 경로에 대해 모두 같은 길의 경우의 수를 가지도록 예외성을 제거하기 위해 ㅇ행과 열의 인덱스를 각각 하나씩 추가해준다.
        System.out.println(dist[N-1][M-1]);  // dist에는 (N, M) 도착 시의 이동 방향 및 횟수가 저장되어 있음
    }

    static void bfs(int i, int j) {
        Queue<Integer> Q = new LinkedList<>();
        Q.add(i);
        Q.add(j);
        
        dist[i][j] = 1;
        int[][] dir = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};   // 한 지점에서 갈 수 있는 동서남북 방향 배열로 선언
        
        while (!Q.isEmpty()) {
            i = Q.poll();
            j = Q.poll();

            for (int k=0; k<4; k++) {
                int nx = i + dir[i][0];
                int ny = j + dir[i][1];

                // 방문 조건 체크
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;   // 미로 범위를 벗어나면 pass
                if (maze[nx][ny] == '0') continue;
                if (dist[nx][ny] != -1) continue;

                dist[nx][ny] = dist[i][j] + 1;
                Q.add(nx);
                Q.add(ny);
            }
        }
    }
}
