package chap04;

import java.util.Scanner;

public class IntQueueTest {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        IntQueue s = new IntQueue(64);  //최대 64개의 원소까지 저장 가능
        
        while(true) {
            System.out.println("현재 데이터 수: " + s.size() + "/" + s.capacity());
            System.out.print("(1) enqueue  (2) dequeue  (3) peek  " +
                    "(4) dump  (5) exit : ");
            int menu = stdIn.nextInt();
            if(menu == 0) break;

            int x;
            switch(menu) {
                case 1:
                    System.out.print("데이터: ");
                    x = stdIn.nextInt();
                    try {
                        s.enque(x);
                    } catch (IntQueue.OverflowIntQueueException e) {
                        System.out.println("큐가 가득 찼습니다.");
                    }
                    break;

                case 2:
                    try {
                        x = s.deque();
                        System.out.println("디큐한 데이터는 " + x + "입니다.");
                    } catch (IntQueue.EmptyIntQueueException e) {
                        System.out.println("큐가 비어 있습니다.");
                    }
                    break;

                case 3:
                    try {
                        x = s.peek();
                        System.out.println("피크된 데이터는 " + x + "입니다.");
                    } catch (IntQueue.EmptyIntQueueException e) {
                        System.out.println("큐가 비어 있습니다.");
                    }
                    break;

                case 4:
                    s.dump();
                    break;
            }
        }
    }
}
