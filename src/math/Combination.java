package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Combination {
    static int[] num_arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());  // 집합 원소의 개수 입력
        
        num_arr = new int[N];
        visited = new boolean[N];

        for (int i=0; i<N; i++)
            num_arr[i] = Integer.parseInt(br.readLine());


        // 재귀 방식을 이용한 구현
        for (int i=1; i<=N; i++) {
            System.out.println("\n" + N + "개 중에 " + i + "개 뽑음");
            comb_rec(num_arr, visited, 0, i);
        }
        // 백트래킹을 이용한 구현
        for (int i=1; i<=N; i++) {
            System.out.println("\n" + N + "개 중에 " + i + "개 뽑음");
            comb_back(num_arr, visited, 0, i);
        }

    }

    /* 조합 경우의 수 구하기 */
    // nCr = n-1Cr-1 + n-1Cr
    // 원소를 선택할 경우 + 선택하지 않을 경우의 합을 재귀 호출로 구함
    public static int combination(int n, int r) {
        if (n == r || r == 0)
            return 1;
        else
            return combination(n-1, r-1) + combination(n-1, r);
    }

    /* 조합 구하기 */

    // 재귀 방식
    // visited[] : 현재 뽑은 인덱스에 대한 방문 여부를 저장하는 배열
    // r : 뽑아야 하는 인덱스의 남은 총 개수 => 하나씩 감소 or 그대로
    // depth : 현재의 인덱스 => 재귀호출마다 무조건 하나씩 증가
    static void comb_rec(int[] arr, boolean[] visited, int depth, int r) {
        // 배열 원소 출력
        if(r == 0) {
            print_arr(arr, visited);
            return;
        }

        if(depth == arr.length) {  // 배열의 끝에 도착하면 더이상 조합을 만들 수 없으므로 종료
            return;
        } else {
            visited[depth] = true;
            comb_rec(arr, visited, depth+1, r-1);

            visited[depth] = false;
            comb_rec(arr, visited, depth+1, r);
        }
    }

    // 백트래킹 방식
    static void comb_back(int[] arr, boolean[] visited, int start, int r) {
        if (r == 0) {  // 더이상 뽑을 개수가 없을 때
            print_arr(arr, visited);
            return;
        } else {
            for (int i=start; i<arr.length; i++) {
                visited[i] = true;
                comb_back(arr, visited, i+1, r-1);  // 뽑아야 할 개수는 1씩 줄어들고, 방문할 인덱스는 1씩 증가한다.
                visited[i] = false;
            }
        }
    }

    // 배열 출력
    static void print_arr(int[] arr, boolean[] visited) {
        for (int i=0; i<arr.length; i++) {
            if (visited[i] == true)
                System.out.println(arr[i] + " ");
        }
        System.out.println();
    }
    
}
