package chap01;

public class Max4M {
    static int max4(int a, int b, int c, int d) {
        int max = a;
        if(b > max) max = b;
        if(c > max) max = c;
        if(d > max) max = d;

        return max;
    }

    static int min3(int a, int b, int c) {
        int min = a;
        if(b < min) min = b;
        if(c < min) min = c;

        return min;
    }

    public static void main(String[] args) {
        System.out.println(max4(3,1,2,5));
        System.out.println(min3(2,2,7));
    }
}
