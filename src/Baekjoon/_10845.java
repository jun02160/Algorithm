package Baekjoon;

import java.util.Scanner;

class Queue {

    int[] que;
    int front;
    int rear;

    public Queue(int capacity) {
        front = 0;
        rear = -1;

        que = new int[capacity];

    }

    public int push(int x) {
        que[++rear] = x;

        return x;
    }

    public int pop() {
        if(empty() == 1)
            return -1;

        return que[front++];
    }

    public int size() {
        return rear - front + 1;
    }

    public int empty() {
        if(size() <= 0)
            return 1;
        return 0;
    }

    public int back() {
        if(empty() == 1)
            return -1;
        return que[rear];
    }

    public int front() {
        if(empty() == 1)
            return -1;
        return que[front];
    }
}

public class _10845 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        Queue que = new Queue(N);

        for(int i=0; i<N; i++) {
            String c = sc.next();
            switch (c) {
                case "push" -> {
                    int x = sc.nextInt();
                    System.out.println(que.push(x));
                }
                case "pop" -> System.out.println(que.pop());
                case "size" -> System.out.println(que.size());
                case "empty" -> System.out.println(que.empty());
                case "front" -> System.out.println(que.front());
                case "back" -> System.out.println(que.back());
                default -> {
                }
            }

        }
    }
}