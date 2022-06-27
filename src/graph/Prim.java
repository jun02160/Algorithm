package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Prim {
    public static class Edge {
        int vertex, weight;

        public Edge(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }

    public static int V, E, result;
    public static boolean[] visited;  // 노드 방문 여부 체크
    public static int[] minEdge;   // 최소 거리를 저장할 배열
    public static List<Edge>[] edge;  // 노드 간의 연결관계를 인접 리스트로 표현

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        edge = new ArrayList[V+1];

        for (int i=0; i<=V; i++) {
            edge[i] = new ArrayList<Edge>();
        }

        for (int i=0; i<E; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            
            // 양방향으로 연결됨을 인접 행렬에 저장
            edge[from].add(new Edge(to, weight));
            edge[to].add(new Edge(from, weight));
        }

        visited = new boolean[V+1];
        minEdge = new int[V+1];

        Arrays.fill(minEdge, Integer.MAX_VALUE);
        minEdge[1] = 0;     // 1번 정점부터 시작
        result = 0;

        for (int i=1; i<=V; ++i) {
            int min = Integer.MAX_VALUE;
            int cur = 0;

            for (int j=1; j<=V; ++j) {

                if (!visited[j] && min > minEdge[j]) {
                    min = minEdge[j];
                    cur = j;
                }
            }

            // 노드 방문 표시를 하고, 최소 가중치 결과에 합산
            visited[cur] = true;
            result += min;

            for (int j=0; j<edge[cur].size(); ++j) {
                Edge e = edge[cur].get(j);

                // 방문 여부와 최소 가중치를 가지는가의 조건을 체크
                if (!visited[e.vertex] && minEdge[e.vertex] > e.weight) {
                    minEdge[e.vertex] = e.weight;
                }
            }
        }
        System.out.println(result);
    }
}
