package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Nodes<E> {
    E data;
    Nodes<E> prev;
    Nodes<E> next;

    Nodes() {
        data = null;
        prev = next = this;
    }

    Nodes(E data, Nodes<E> prev, Nodes<E> next) {
        this.data = data;
        this.prev = prev;
        this.next = next;
    }
}
class DCLinkedList<E> {
    private Nodes<E> head;
    private Nodes<E> crnt;

    public DCLinkedList() {
        head = crnt = new Nodes<E>();
    }

    public boolean isEmpty() {
        return head.next == head;
    }

    public void add(E value) {
        Nodes<E> newNode = new Nodes<E>(value, crnt, crnt.next);
        crnt.next = crnt.next.prev = newNode;  // crnt의 이전과 다음 노드를 모두 새로운 노드로 연결하는 원형 형태
        crnt = newNode;
    }
    
    public void remove(Nodes<E> crnt) {
        if(!isEmpty()) {
            // crnt 노드의 앞뒤 연결을 끊어내기
            crnt.prev.next = crnt.next;
            crnt.next.prev = crnt.prev;
            crnt = crnt.prev;
        }
    }

    public E moveK(int range) {
        int cnt = 0;
        Nodes<E> temp = crnt.next;
        while(cnt != range-1) {
            if(temp == head) {
                temp = temp.next;
                continue;
            }
            cnt++;
            temp = temp.next;
        }
        crnt = temp;

        if(crnt == head) {
            crnt = crnt.next;
        }
        remove(crnt);
        return crnt.data;


    }

    public void printAll() {
        Nodes<E> temp = head.next;
        System.out.print("<");
        while(temp.next != head) {  // 다시 꼬리로 돌아오기 전까지
            System.out.print(temp.data + ", ");
            temp = temp.next;
        }

        System.out.println(temp.data + ">");
    }
}

public class _1158_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        DCLinkedList<Integer> list = new DCLinkedList<>();
        DCLinkedList<Integer> result = new DCLinkedList<>();

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        for(int i=1; i<=n; i++){
            list.add(i);
        }

        for(int i=0; i<n; i++) {
            int num = list.moveK(k);
            result.add(num);
        }

        result.printAll();
    }
}
