package chap06;

import java.util.Scanner;

// 힙 정렬
public class HeapSort {
    static void swap(int[] arr, int idx1, int idx2) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }


    // arr[left] ~ arr[right]를 힙으로 만들기 (부모 >= 자식의 대소 규칙 유지)
    static void downHeap(int[] arr, int left, int right) {
        int temp = arr[left];
        int child;    // 부모보다 큰 값을 가진 자식 노드
        int parent;

        // left 이전은 모두 힙 정렬이 완료된 상태
        for(parent = left; parent < (right+1) / 2; parent = child) {
            // 트리에서의 인덱스 규칙
            int cl = parent*2 + 1;
            int cr = cl + 1;

            child = (cr <= right && arr[cr] > arr[cl]) ? cr : cl;   // 더 큰 값을 가진 노드를 자식에 대입한 후 부모와 swap
            if (temp >= arr[child])
                break;
            arr[parent] = arr[child];
        }

        arr[parent] = temp;
    }

    // 힙 정렬
    static void heapSort(int[] arr, int n) {
        // 오른쪽 아래의 서브트리부터 힙 정렬 순차적으로 진행
        for (int i= (n-1)/2; i>=0; i--)
            downHeap(arr, i, n-1);
        
        // 아직 정렬되지 않은 부분 전체 트리에서 정렬
        for (int i=n-1; i>0; i--) {
            swap(arr, 0, i);
            downHeap(arr, 0, i-1);
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("힙 정렬");
        System.out.print("요솟수: ");
        int nx = stdIn.nextInt();
        int[] x = new int[nx];

        for(int i=0; i<nx; i++) {
            System.out.print("x[" + i + "] : ");
            x[i] = stdIn.nextInt();
        }

        heapSort(x, nx);

        System.out.println("오름차순으로 정렬했습니다.");
        for (int i=0; i<nx; i++)
            System.out.println("x[" + i + "] = " + x[i]);

    }
}
