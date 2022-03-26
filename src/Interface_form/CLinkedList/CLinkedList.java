package Interface_form.CLinkedList;


// 원형 연결 리스트
public class CLinkedList<E> {
    private Node<E> tail;
    private Node<E> crnt;
    private Node<E> before;
    private int size;

    public CLinkedList() {
        this.tail = null;
        this.crnt = null;
        this.before = null;
        size = 0;
    }

/*
    add Method
*/
    // 앞쪽에 삽입(head가 새로운 노드로 변경)
    public void addFront(E value) {
        Node<E> newNode = new Node<>(value);
        if(tail == null) {
            tail = newNode;
            newNode.next = newNode;
        } else {
            crnt = tail.next;
            while(crnt.next != tail.next) {
                crnt = crnt.next;
            }
            newNode.next = crnt.next;
            crnt.next = newNode;
            tail.next = newNode;
        }
        size++;
    }
    
    // 뒤쪽에 삽입(tail이 새로운 노드로 변경)
    public void addBack(E value) {
        Node<E> newNode = new Node<>(value);
        if(tail == null) {
            tail = newNode;
            newNode.next = newNode;
        } else {
            crnt = tail.next;
            while(crnt.next != tail.next) {
                crnt = crnt.next;
            }
            newNode.next = crnt.next;
            crnt.next = newNode;
            tail = newNode;   // 새로운 노드를 꼬리로 지정하는 부분만 다름
        }
        size++;
    }

/*
    search Method
*/
    public boolean searchFirst() {
        if(tail == null) {  //원형 리스트 => 리스트의 끝을 검사하는 코드 X
            return false;
        }
        before = tail;
        crnt = tail.next;

        return true;
    }

    public boolean searchNext() {
        if(tail == null) {
            return false;
        }

        before = crnt;
        crnt = crnt.next;
        return true;
    }

/*
    remove Method
*/
    public void removeLast() {
        Node<E> head = tail.next;
        if(head != null) {
            Node<E> temp = head.next;
            crnt = head.next;
            while(crnt != head) {
                temp = crnt;
                crnt = crnt.next;
            }
            temp.next = crnt.next;

        }
    }

    public void removeFirst() {
        Node<E> head = tail.next;
        if(head != null) {
            crnt = head;
            while(crnt.next != head) {
                crnt = crnt.next;
            }
            Node<E> temp = crnt.next;
            head = temp.next;
            crnt.next = head;
        }
    }

    public void remove(E value) {
        Node<E> temp = new Node<>(value);
        crnt = tail.next.next;
        while(crnt.data != temp.data) {
            temp = crnt;
            crnt = crnt.next;
        }
        temp.next = crnt.next;
    }


/*
    size Method
*/
    public int size() {
        return size;
    }

/*
    isEmpty Method
*/
    public boolean isEmpty() {
        return size == 0;
    }

/*
    clear Method
*/
    public void clear() {
        for(Node<E> temp = tail; temp!=null; ) {
            Node<E> nextNode = temp.next;

            temp.data = null;
            temp.next = null;
            temp = nextNode;
        }

        tail = null;
        size = 0;
    }


}
