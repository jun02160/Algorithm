/*
package chap03;

public class DFS {
    static int[][] graph;   // 그래프를 표현하기 위해 인접행렬
    static boolean[] visited;   // 방문한 정점 표현

    static void dfs(int node) {
        visited[node] = true;   // 함수 호출

        for (int i=0; i<graph[node].length; i++) {
            // 간선이 존재하고 방문하지 않은 정점이라면 함수 호출(재귀방식)
            if(graph[node][i] == 1 && visited[i] == false {
                dfs(i);
            }
        }
    }
}
*/
