package Do_it_자료구조와_함께_배우는_알고리즘_입문_JAVA.chap06;

import java.util.Arrays;
import java.util.GregorianCalendar;
import static java.util.GregorianCalendar.*;

/* 클래스 객체 배열의 정렬 => 병합 정렬 */
public class SortCalendar {
    public static void main(String[] args) {
        GregorianCalendar[] x = {
                new GregorianCalendar(2017, NOVEMBER, 1),
                new GregorianCalendar(2002, FEBRUARY, 16),
                new GregorianCalendar(1975, AUGUST, 18),
        };

        Arrays.sort(x);

        for(int i=0; i<x.length; i++)
            System.out.printf("%04d년 %02d월 %02d일\n",
                    x[i].get(YEAR),
                    x[i].get(MONTH)+1,
                    x[i].get(DATE)
            );
    }
}
