/*
package chap03;

import java.util.Stack;

public class DFS_stack {

    public void dfs() {
        Stack<Integer> stack = new Stack<>();

        stack.push(V);   // 시작 노드 push
        visited[V] = true;  // 시작 노드 방문 처리

        while (!stack.isEmpty()) {
            int n = stack.peek();

            boolean flag = false;   // 연결된 노드 중 아직 방문하지 않은 노드

            for (int node : v[n]) {
                if (!visited[node])  {
                    stack.push(node);
                    visited[node] = true;  // 방문하지 않았던 노드를 push하고 방문 처리
                    flag = true;
                    break;
                }
            }

            //  모든 노드 방문 완료 시 pop
            if (!flag)
                stack.pop();
        }

    }
}
*/
