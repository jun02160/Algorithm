package chap01;

public class forTest {
    static int sum(int N) {
        int sum = 0;

        for(int i=1; i<=N; i++) {
            System.out.print(i!=N ? i + " + " : i + " = ");
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(sum(7));
    }
}
