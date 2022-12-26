package Do_it_자료구조와_함께_배우는_알고리즘_입문_JAVA.chap02;

public class PrimeNumber1 {
    public static void main(String[] args) {
        int counter = 0;
        int ptr = 0;
        int[] prime = new int[500];

        prime[ptr++] = 2;

        for (int n=3; n<=1000; n+=2) {
            int i;
            
            // 이미 찾은 소수로 나누었을 때 나누어 떨어지는 것이 없다면 소수
            for (i=1; i<ptr; i++) {
                counter++;
                if (n % prime[i] == 0)
                    break;
            }
            if (ptr == i)
                prime[ptr++] = n;  // 소수 배열에 저장
        }

        for (int i=0; i<ptr; i++)
            System.out.println(prime[i]);

        System.out.println("나눗셈을 수행한 횟수 : " + counter);
    }
}
