package Do_it_자료구조와_함께_배우는_알고리즘_입문_JAVA.chap01;

public class Multi99Table {
    public static void main(String[] args) {
        System.out.print("   ");
        System.out.print("|");

        for (int i=1; i<=9; i++) {
            System.out.printf("%3d", i);
        }
        System.out.println();

        System.out.print("---+---------------------------");
        System.out.println();

        for (int i=1; i<=9; i++) {
            System.out.printf("%3d", i);
            System.out.print("|");
            for (int j=1; j<= 9; j++) {

                System.out.printf("%3d", i*j);
            }
            System.out.println();
        }
    }
}
