package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2346 {

    // 백준 2346 풍선 터뜨리기
    // SinglyLinkedList
    public static class Node<Integer> {
        int data;
        int num_order;
        Node<Integer> next;
        Node<Integer> prev;

        //생성자
        Node(int data, int num_order) {
            this.data = data;
            this.num_order = num_order;
            this.next = null;
            this.prev = null;
        }

        // 입력받은 수를 헤더 노드부터 시작해 노드로 연결하기 위한 add() 메소드
        public void add(int data, int order) {
            Node<Integer> balloon = this;
            while(balloon.next != null)
                balloon = balloon.next;
            balloon.next = new Node<>(data, order);
            if(balloon.prev == null)
                balloon.prev = balloon.next;  //맨 끝과 맨 처음을 이어주는 원형연결리스트의 형태
            balloon.next.prev = balloon;  // 노드 순회
        }

        // 풍선을 터뜨리고 리스트에서 연결을 끊어버리는 remove() 메소드
        public int remove(Node<Integer> balloon) {
            //LinkedList에 단 2개의 원소만 남은 경우(자기자신의 이전의 이전은 자기자신으로 다시 되돌아온다)
            if(balloon.prev.prev == balloon) {
                System.out.print(balloon.num_order + " ");
                System.out.print(balloon.prev.num_order + " ");
                return 0;
            }

            //노드 삭제를 위해 링크 연결을 끊고 다시 이어주기
            Node<Integer> temp = balloon.prev;
            temp.next = balloon.next;
            temp = temp.next;
            temp.prev = balloon.prev;
            System.out.print(balloon.num_order + " ");

            return balloon.data;
        }
    }




    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        Node<Integer> head = new Node<>(Integer.parseInt(st.nextToken()), 1);  //헤더 노드

        for(int i=1; i<N; i++) {
            head.add(Integer.parseInt(st.nextToken()), i+1);
        }

        Node<Integer> flag = head;
        while(flag.next != null)
            flag = flag.next;
        //맨 끝의 노드와 맨 앞의 노드를 서로 연결 (서로의 링크를 가리키도록!)
        flag.next = head;
        head.prev = flag;
        flag = flag.next;

        if(N==1) {
            System.out.println(1);
            return;
        }

        for(int i=1; i<N; i++) {
            int move = flag.remove(flag);
//            System.out.println(move);
            // 이동할 정수가 양수일 때
            if(move > 0) {
                while(move-- > 0)  //오른쪽으로 이동(move가 0이 될 때까지 감소)
                    flag = flag.next;
            } else {  // 이동할 정수가 음수일 때
                while(move++ < 0)  //왼쪽으로 이동(move가 0이 될 때까지 증가)
                    flag = flag.prev;
            }
        }
    }
}
