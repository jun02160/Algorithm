package chap02;

import java.util.Random;
import java.util.Scanner;

public class MaxOfArrayRand {
    
    static int maxOf(int[] arr) {
        int max = arr[0];
        for (int i=1; i<arr.length; i++) 
            if (arr[i] > max) max = arr[i];
        return max;
    }

    public static void main(String[] args) {
        Random rand = new Random();
        Scanner stdIn = new Scanner(System.in);
        
        System.out.println("키의 최댓값을 구합니다.");
        System.out.print("사람 수 : ");
        int num = rand.nextInt(51);   // 0명~50명 중 랜덤으로 사람 수 지정
        System.out.println(num);

        int[] height = new int[num];
        
        System.out.println("키 값은 아래와 같습니다.");
        for(int i=0; i<num; i++) {
            height[i] = 100 + rand.nextInt(90);   // 100~189 사이의 랜덤 값으로 요소 값 지정
            System.out.println("height[" + i + "]: " + height[i]);
        }

        System.out.println("최댓값은 " + maxOf(height) + "입니다." );
    }
}
