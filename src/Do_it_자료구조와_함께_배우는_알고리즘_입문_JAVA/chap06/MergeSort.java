package Do_it_자료구조와_함께_배우는_알고리즘_입문_JAVA.chap06;

import java.util.Scanner;

class MergeSort {
    
    static int[] buff;   // 작업용 배열

    // a[left]~a[right]를 재귀호출 방식으로 병합 정렬]
    static void __mergeSort(int[] a, int left, int right) {
        if (left < right) {
            int i;
            int center = (left + right) / 2;
            int p=0;
            int j=0;
            int k=left;

            // 배열의 앞부분과 뒷부분을 각각 병합정렬
            __mergeSort(a, left, center);
            __mergeSort(a, center+1, right);

            
            // 1. 배열 a의 앞부분을 임시 버퍼 buff에 그대로 옮겨두고,
            for (i=left; i<=center; i++)
                buff[p++] = a[i];

            // 2, buff(a배열 앞부분 원소) VS 배열 a의 뒷부분을 비교하여 병합정렬한 값을 배열 a에 저장한다.
            while (i <= right && j < p)
                a[k++] = (buff[j] <= a[i]) ? buff[j++] : a[i++];

            // 3. 배열 a의 끝을 맞이했을 때 buff에 남아있는 원소를 다시 그대로 배열 a에 붙여준다.
            while (j < p)
                a[k++] = buff[j++];
        }
    }

    // 병합 정렬
    static void mergeSort(int[] a, int n) {
        buff = new int[n];   // 작업용 배열 생성

        __mergeSort(a, 0, n-1);   // 배열 전체 병합 정렬 -> 내부에서 또 병합 정렬이 이루어지는 형태

        buff = null;   // 작업용 배열 해제
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("병합 정렬");
        System.out.println("요솟수: ");
        int nx = stdIn.nextInt();
        int[] x = new int[nx];

        for(int i=0; i<nx; i++) {
            System.out.print("x[" + i + "]: ");
            x[i] = stdIn.nextInt();
        }

        mergeSort(x, nx);

        System.out.println("오름차순으로 정렬합니다.");
        for(int i=0; i<nx; i++)
            System.out.println("x[" + i + "]=" + x[i]);
    }


    
}
