package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Node<E> {
    E data;
    Node<E> prev;
    Node<E> next;

    Node(E data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

class DLinkedList<E> {
    public Node<E> head;
    public Node<E> tail;
    public int size;


    public DLinkedList() {
        head = new Node<>(null);
        tail = new Node<>(null);
        this.size = 0;
    }


    public void add(E value) {
        Node<E> newNode = new Node<E>(value);
        if(size == 0) {
            head.next = newNode;
            newNode.prev = head;
            tail.prev = newNode;
            newNode.next = tail;
        } else {
            tail.prev.next = newNode;
            newNode.prev = tail.prev;
            tail.prev = newNode;
            newNode.next = tail;
        }
        size++;
    }
    
    public void cursorleft() {
        if(tail.prev != head) {
            Node<E> temp = new Node<E>(null);
            temp.prev = tail.prev.prev;
            temp.next = tail.prev;
            tail.prev.prev.next = temp;
            // 이동
            tail.prev.prev = temp;
            tail.prev.next = temp.next;
            tail = temp;
        }
    }

    public void cursorright() {
        if(tail.next != null) {
            Node<E> temp = new Node<E>(null);
            temp.next = tail.next.next;
            temp.prev = tail.next;
            // 이동
            tail.prev.next = tail.next;
            tail.next.prev = tail.prev;
            tail = temp;
        }
    }

    public void remove() {

        if(tail.prev != head) {
            //tail.prev(마지막 요소) 연결 끊기
            tail.prev.prev.next = tail;
            tail.prev = tail.prev.prev;
        }
        size--;
    }

    public void printNode() {
        Node<E> node = head;
        int index = 0;
        for(; index<=size; node=node.next) {
            Node<E> nextNode = node.next;
            if(nextNode.data != null) {
                System.out.print(nextNode.data);
            }
            index++;
        }
        System.out.println();
    }
}

public class _1406_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        DLinkedList<String> list = new DLinkedList<>();

        String word = br.readLine();
        int N = Integer.parseInt(br.readLine());

        String[] instruction = word.split("");
        for(int i=0; i<word.length(); i++) {
            list.add(instruction[i]);
        }

        for(int i=0; i<N; i++) {
            String command = br.readLine();
            char c = command.charAt(0);

            switch (c) {
                case 'L':
                    list.cursorleft();
                    break;
                case 'D':
                    list.cursorright();
                    break;
                case 'B':
                    list.remove();
                    break;
                case 'P':
                    list.add(String.valueOf(command.charAt(2)));
                    break;
                default:
                    break;
            }
        }
        list.printNode();

    }
}
