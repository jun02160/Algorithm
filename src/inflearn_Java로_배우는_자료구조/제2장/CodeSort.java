package inflearn_Java로_배우는_자료구조.제2장;

import java.util.Scanner;

public class CodeSort {
    static int n = 0;
    static Person1[] members;
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        n = stdIn.nextInt();

        members = new Person1[n];

        bubbleSort();

    }

    private static void bubbleSort() {
        for (int i=n-1; i>0; i--) {
            for (int j=0; j<i; j++) {
                if (members[j].name.compareTo(members[j+1].name) > 0) {
                    Person1 tmp = members[j];
                    members[j] = members[j+1];
                    members[j+1] = tmp;
                }
            }
        }
    }

}
