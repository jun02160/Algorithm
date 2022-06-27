package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _1197 {
    static int V;    // 노드 개수
    static int E;    // 간선 개수
    static boolean[] visited;    // 노드 방문 여부를 저장
    static ArrayList<Node>[] adj;     // 인접 리스트
    static PriorityQueue<Node> pq;  // 우선순위 큐
    
    public void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        
        // 인접 리스트 생성
        adj = new ArrayList[V + 1];
        for (int i=1; i<=V; i++) {
            adj[i] = new ArrayList<>();
        }
        
        for (int i=0; i<E; i++) {
            st = new StringTokenizer(br.readLine());
            
            int to = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            adj[to].add(new Node(from, weight));
            adj[from].add(new Node(to, weight));
            
        }
        
        System.out.println(prim());
    }
    
    public int prim() {
        int res = 0;
        
        visited = new boolean[V + 1];
        pq = new PriorityQueue<Node>();
        pq.add(new Node(1, 0));
        
        int cnt = 0;
        while(!pq.isEmpty()) {
            Node edge = pq.poll();
            
            if (visited[edge.to]) {
                continue;
            }
            
            res += edge.weight;  // 방문하지 않은 노드인 경우 가중치 더하기
            visited[edge.to] = true;  // 방문 표시
            
            // 모든 노드를 방문한 경우 = 최소 가중치(MST) 구하기 끝
            if (++cnt == V) {
                return res;
            }
            
            // 연결된 노드 중 방문하지 않은 노드 참색
            for (int i=0; i<adj[edge.to].size(); i++) {
                Node next = adj[edge.to].get(i);

                if (visited[next.to]) {
                    continue;
                }
                pq.add(next);
            }
        }

        return res;
    }

    class Node implements Comparable<Node> {
        int to;
        int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return o.weight >= this.weight ? -1 : 1;
        }
    }
}
