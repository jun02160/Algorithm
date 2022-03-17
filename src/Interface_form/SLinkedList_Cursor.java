package Interface_form;

import java.util.Comparator;

public class SLinkedList_Cursor<E> {
    class Node<E> {
        private E data;
        private int next;   // 리스트의 뒤쪽 포인터
        private int dnext;  // 프리리스트의 뒤쪽 포인터

        void set(E data, int next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node<E>[] n;   //리스트 본체 = 배열의 형태
    private int size;      //리스트의 용량 (가장 큰 데이터 수)
    private int max;       //사용중인 꼬리 record
    private int head;      //머리 노드
    private int crnt;      //선택 노드
    private int deleted;   //free 리스트의 머리 노드
    private static final int NULL = -1;   //마지막 노드(꼬리)를 나타내는 값 (음수 인덱스 존재X)

    // 생성자 
    public SLinkedList_Cursor(int capacity) {
        head = crnt = max = deleted = NULL;
        try {
            n = new Node[capacity];   // 매개변수로 넘겨 받은 capacity 크기의 배열 생성
            for(int i=0; i<capacity; i++)
                n[i] = new Node<E>();  // 배열의 각 요소는 Node형 객체
            size = capacity;
        } catch (OutOfMemoryError e) {
            size = 0;
        }
    }

    // 다음에 삽입하는 record의 인덱스를 구하는 메소드
    private int getInsertIndex() {
        if(deleted == NULL) {   // free 리스트가 비어있는 경우(삭제할 record X)
            if(max < size)
                return ++max;
            else  // 용량이 오버된 경우
                return NULL;
        } else {
            int rec = deleted;  // free 리스트에서 값을 꺼내옴
            deleted = n[rec].dnext;
            return rec;
        }
    }

    // 삭제할 인덱스 record를 free 리스트에 등록
    private void deleteIndex(int idx) {
        if(deleted == NULL) {
            deleted = idx;
            n[idx].dnext = NULL;
        } else {
            int rec = deleted;
            deleted = idx;
            n[idx].dnext = rec;
        }
    }

    //노드를 검색하는 메소드
    public E search(E obj, Comparator<? super E> c) {
        int ptr = head;

        while(ptr != NULL) {
            if(c.compare(obj, n[ptr].data) == 0) {
                crnt = ptr;
                return n[ptr].data;
            }
            ptr = n[ptr].next;
        }
        return null;
    }

/*
    add Method
*/
    public void addFirst(E obj) {
        int ptr = head;
        int rec = getInsertIndex();
        if(rec != NULL) {
            head = crnt = rec;
            n[head].set(obj, ptr);
        }
    }

    public void addLast(E obj) {
        if(head == NULL)
            addFirst(obj);
        else {
            int ptr = head;
            while(n[ptr].next != NULL)
                ptr = n[ptr].next;
            int rec = getInsertIndex();
            if(rec != NULL) {
                n[ptr].next = crnt = rec;
                n[rec].set(obj, NULL);
            }
        }
    }

/*
    remove Method
*/
    public void removeFirst() {
        if(head != NULL) {
            int ptr = n[head].next;
            deleteIndex(head);
            head = crnt = ptr;
        }
    }

    public void removeLast() {
        if(head != NULL) {
            if(n[head].next == NULL)
                removeFirst();
            else {
                int ptr = head;
                int pre = head;

                while(n[ptr].next != NULL) {
                    pre = ptr;
                    ptr = n[ptr].next;
                }
                n[pre].next = NULL;
                deleteIndex(ptr);
                crnt = pre;
            }
        }
    }

    public void remove(int p) {
        if(head != NULL) {
            if(p == head)
                removeFirst();
            else {
                int ptr = head;

                while(n[ptr].next != p) {
                    ptr = n[ptr].next;
                    if(ptr == NULL)
                        return;
                }
                n[ptr].next = NULL;
                deleteIndex(p);
                n[ptr].next = n[p].next;
                crnt = ptr;
            }
        }
    }

    //선택한 노드를 삭제
    public void removeCurrentNode() {
        remove(crnt);
    }

    // 모든 노드를 삭제
    public void clear() {
        while (head != NULL)
            removeFirst();
        crnt = NULL;
    }

    // 선택 노드를 하나 뒤쪽으로 이동
    public boolean next() {
        if(crnt == NULL || n[crnt].next == NULL)
            return false;
        crnt = n[crnt].next;
        return true;
    }

    // 선택 노드 출력
    public void printCurrentNode() {
        if(crnt == NULL)
            System.out.println("선택 노드가 없습니다.");
        else
            System.out.println(n[crnt].data);
    }

    // 모든 노드를 출력
    public void dump(){
        int ptr = head;

        while(ptr != NULL) {
            System.out.println(n[ptr].data);
            ptr = n[ptr].next;
        }
    }
}

