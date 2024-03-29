package Do_it_자료구조와_함께_배우는_알고리즘_입문_JAVA.chap03;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class PhysExamSearch {
    // 신체 검사 데이터 배열에서 이진 검색하기
    static class PhyscData {
        private String name;
        private int height;
        private double vision;

        public PhyscData(String name, int height, double vision) {
            this.name = name;
            this.height = height;
            this.vision = vision;
        }

        // 문자열을 반환하는 메서드
        public String toString() {
            return name + " " + height + " " + vision;
        }

        // 오름차순으로 정렬하기 위한 comparator
        public static final Comparator<PhyscData> HEIGHT_ORDER = new HeightOrderComparator();

        private static class HeightOrderComparator implements Comparator<PhyscData> {
            public int compare(PhyscData d1, PhyscData d2) {
                return  (d1.height > d2.height) ? 1 : (d1.height < d2.height) ? -1 : 0;
            }
        }

        public static void main(String[] args) {
            Scanner stdIn = new Scanner(System.in);
            PhyscData[] x = {
                    new PhyscData("이나령", 162, 0.3),
                    new PhyscData("유지훈", 168, 0.4),
                    new PhyscData("박예준", 158, 0.2),
            };

            System.out.print("몇 cm인 사람을 찾고 있나요? : ");
            int height = stdIn.nextInt();
            int idx = Arrays.binarySearch(
                    x,
                    new PhyscData("", height, 0.0),
                    PhyscData.HEIGHT_ORDER
            );

            if (idx < 0)
                System.out.println("요소가 없습니다.");
            else {
                System.out.println("x["+idx+"]에 있습니다.");
                System.out.println("찾은 데이터: " + x[idx]);
            }
        }
    }
}
