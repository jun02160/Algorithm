package chap01;

public class num_pira {
    static void npira(int n) {
        int mid = n-1;
        for(int i=0; i<n; i++) {
            for(int j=0; j<=n*2+1; j++) {
                if(j >= mid-i && j<= mid+i)
                    System.out.print(i+1);
                else
                    System.out.print(' ');
            }
            System.out.println();
        }
    }

    static void npira_correct(int n) {
        for (int i = 1; i <= n; i++) { 					// i행 (i = 1, 2, … ,n)
            for (int j = 1; j <= n - i + 1; j++) 		// n-i+1개의 ' '를 나타냄
                System.out.print(' ');
            for (int j = 1; j <= (i - 1) * 2 + 1; j++) 	// (i-1)*2+1개의 '*'를 나타냄
                System.out.print(i % 10);
            System.out.println(); 						// 개행(줄변환)
        }
    }

    public static void main(String[] args) {
        npira(4);
        npira_correct(4);
    }
}
