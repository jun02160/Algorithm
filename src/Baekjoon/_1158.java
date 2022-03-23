package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class _1158 {
    // 백준 1158 요세푸스 문제
    // CircularLinkedList
    /*public static class Node<Integer> {
        int data;
        Node<Integer> next;
        Node<Integer> prev;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }


        public void add(int data) {
            Node<Integer> person = this;

            while (person.next != null)   //LinkedIterator를 사용하면 hasnext()로 처리 가능
                person = person.next;
            person.next = new Node<>(data);

            if (person.prev == null)
                person.prev = person.next;

            person.next.prev = person;
        }

        public int remove(Node<Integer> person) {
            if (person.prev.prev == person) {
                System.out.print(person.data + " ");
                System.out.print(person.prev.data + " ");

                return 0;
            }

            Node<Integer> temp = person.prev;
            temp.next = person.next;  //person을 건너뛰고 그 다음 사람과 연결
            temp = temp.next;

            temp.prev = person.prev;
            System.out.print(person.data + " ");

            return person.data;
        }
    }

*//*    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Node<Integer> head = new Node<>(1);
        for(int i=1; i<N; i++) {
            head.add(i+1);
        }

        Node<Integer> ptr = head;
        while(ptr.next != null)
            ptr = ptr.next;

        // 앞뒤 서로 연결
        ptr.next = head;
        head.prev = ptr;

        int move = K;
        while(move > 0) {
            ptr.next;
        }

    }*/
    // 백준 1158 요세푸스 문제
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 1; i <= N; i++)
            list.add(i);

        int index = 0;
        System.out.print("<");

        while (!list.isEmpty()) {
            index += K - 1;
            while (index > list.size() - 1) {
                index -= list.size();
            }
            System.out.print(list.remove(index));
            System.out.print(!list.isEmpty() ? ", " : ">");
        }
    }
}

