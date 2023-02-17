package math;

public class PrimeNumber {
    public static void main(String[] args) {

        int maxNum  = 100000;   // 판별할 대량의 소수 중 최댓값

        // 1. 배열 생성 후 초기화
        int[] arr = new int[100001];
        for (int i=2; i<=maxNum; i++) {
            arr[i] = i;
        }

        // 2. 2부터 시작하여 특정 수의 배수에 해당한다면 배열에서 지운다.(0으로 변경)
        for (int i=2; i<=maxNum; i++) {
            if (arr[i] == 0) continue;   // 이미 지워진 수라면 건너뛰기

            // 이미 지워진 숫자가 아닌 경우, 그 배수부터 건너뛰어서 시작
            for (int j=2*i; j<=maxNum; j+=i) {
                arr[j] = 0;
            }
        }

        // 3. 2부터 남아있는 수를 모두 소수라고 판별한다.
        for (int i=2; i<=maxNum; i++) {
            if (arr[i] != 0)
                System.out.println(arr[i]);
        }

        //== 특정 수의 소인수분해 ==//
        int n = 30;   // 30을 소인수분해 해보자!
        for (int i=0; n>1; i++) {
            if (arr[i] != 0) {   // 해당 수가 소수인 경우
                while (n % i == 0) {
                    System.out.println(i);  // 30의 소인수(소수)
                    n /= i;   // 다시 그 수를 소수로 나눈 후에 다시 반복
                }
            }
        }
    }
}
