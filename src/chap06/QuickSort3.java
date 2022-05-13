package chap06;

import chap04.IntStack;

import java.util.Scanner;

// 퀵 정렬의 비재귀적 구현 (스택 & 반복문 이용)
public class QuickSort3 {
    // 배열 요소 a[idx1]과 a[idx2]의 값을 바꾸는 메소드
    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    static void quickSort(int[] arr, int left, int right) {
        // 데이터를 임시 저장하기 위한 스택 공간
        IntStack lstack = new IntStack(right-left+1);
        IntStack rstack = new IntStack(right-left+1);

        // 맨 왼쪽/오른쪽부터 각 스택에 push
        lstack.push(left);
        rstack.push(right);

        while (lstack.isEmpty() != true) {
            // 정렬이 완료된 인덱스부터는 제외한 후 다시 범위 설정 => 스택에서 pop한 범위를 나누는 작업 반복
            
            int pl = left = lstack.pop();   // 왼쪽 커서
            int pr = right = rstack.pop();  // 오른쪽 커서
            int x = arr[(left+right)/2];    // 피벗


            do {
                while(arr[pl] < x) pl++;
                while(arr[pr] > x) pr--;
                if (pl <= pr)
                    swap(arr, pl++, pr--);
            } while (pl <= pr);
            
            if (left < pr) {
                lstack.push(left);
                rstack.push(pr);
            }
            if (pl < right) {
                lstack.push(pl);
                rstack.push(right);
            }
        }

        
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("퀵 정렬");
        System.out.print("요솟수 : ");
        int nx = stdIn.nextInt();
        int[] x = new int[nx];

        for(int i=0; i<nx; i++) {
            System.out.print("x[" + i + "]:");
            x[i] = stdIn.nextInt();
        }

        quickSort(x, 0, nx-1);

        System.out.println("오름차순으로 정렬했습니다.");
        for(int i=0; i<nx; i++)
            System.out.println("x[" + i + "]= " + x[i]);

    }
}
