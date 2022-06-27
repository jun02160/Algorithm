package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Kruskal {
    static int V, E;   // V = 노드의 개수,  E = 간선의 개수
    static int[][] graph;
    static int[] parent;
    static int finalCost;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        // 그래프의 연결 상태 (Node1, Node2, Cost)
        graph = new int[E][3];   // 연결된 노드 간의 관계와 비용을 저장한 배열
        for (int i=0; i<E; i++) {
            st = new StringTokenizer(br.readLine());
            graph[i][0] = Integer.parseInt(st.nextToken());
            graph[i][1] = Integer.parseInt(st.nextToken());
            graph[i][2] = Integer.parseInt(st.nextToken());
        }
        parent = new int[V];
        finalCost = 0;
        
        // 간선 비용을 기준으로 오름차순 정렬  for 최소비용 찾기
        Arrays.sort(graph, (o1, o2) -> Integer.compare(o1[2], o2[2]));

        // makeSet
        for (int i=0; i<V; i++) {
            parent[i] = i;
        }

        // 낮은 비용부터 크루스칼 알고리즘 진행 (= Edge의 수만큼)
        for (int i=0; i<E; i++) {
            System.out.println(i + "번째");

            // 같은 부모인지 (= 사이클 형성 여부)를 판별하는 조건문
            if (find(graph[i][0] - 1) != find(graph[i][1] - 1)) {
                System.out.println(graph[i][0] + " " + graph[i][1]);
                System.out.println("<선택된 간선>");
                System.out.println(Arrays.toString(graph[i]));

                union(graph[i][0] - 1, graph[i][1] - 1);
                finalCost += graph[i][2];    // 최종 비용에 간선의 비용을 추가해나감

                System.out.println("<각 노드가 가리키고 있는 부모>");
                System.out.println(Arrays.toString(parent) + "\n");
                continue;
            }
        }

        System.out.println("최종 비용 : " + finalCost);
    }

    // parent를 찾는 메소드
    public static int find(int x) {
        if (parent[x] == x) {
            System.out.println(x);
            return x;
        } else {
            System.out.println("Not find");
            return find(parent[x]);
        }
    }

    // 선택한 간선을 합치기 -> 이때 parent가 서로 같으면 cycle 형성 (순환구조)
    public static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a > b) {
            parent[a] = b;
        } else {
            parent[b] = a;
        }
    }
}

