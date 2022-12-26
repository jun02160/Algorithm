package Do_it_자료구조와_함께_배우는_알고리즘_입문_JAVA.chap01;

public class GausTest {
    static int sum_Gaus(int N) {
        int sum = 0;
        sum = (1 + N) * N / 2;

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(sum_Gaus(10));
    }
}
