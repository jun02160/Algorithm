package Interface_form;

import java.util.NoSuchElementException;

public class SLinkedList<E> implements List<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size;  //요소 개수(= 연결된 노드의 개수)

    // 생성자
    public SLinkedList() {
        // head, tail은 각 노드가 가리키는 링크이므로, null로 초기화한다.
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

/*
    search Method
*/

    // 단일 연결리스트는 특정 위치의 데이터를 찾아서 다루는 과정이 많기 때문에 search() 메서드로 정리하기로 한다.
    private Node<E> search(int index) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();  // 인덱스가 범위 밖인 경우 에러 발생
        }

        Node<E> x = head;   //index를 찾기 위해서 노드의 시작(head)부터!

        for(int i=0; i<index; i++) {
            x = x.next;
        }

        return x;
    }

/*
    add Method
*/
    public void addFirst(E value) {
        Node<E> newNode = new Node<E>(value);
        newNode.next = head;
        head = newNode;
        size++;

        if(head.next == null) {
            tail = head;
        }
    }

    //List 인터페이스에서 이미 선언한 add()메서드를 정의하기 위해 오버라이딩을 한다.
    @Override
    public boolean add(E value) {
        addLast(value);
        return true;
    }

    public void addLast(E value) {
        Node<E> newNode = new Node<E>(value);

        // list가 비어 있다면 head 노드가 새로 추가된 노드가 된다.
        if(size == 0) {
            addFirst(value);
            return;
        }

        tail.next = newNode;
        tail = newNode;
        size++;
    }

    @Override
    public void add(int index, E value) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        // 0번째 인덱스(맨앞에) 추가
        if(index == 0) {
            addFirst(value);
            return;
        }

        // 마지막 인덱스 추가
        if(index == size-1) {
            addLast(value);
            return;
        }

        Node<E> newNode = new Node<E>(value);
        Node<E> prevNode = search(index-1);
        Node<E> nextNode = prevNode.next;

        // 연결된 노드와 노드 사이를 끊고 선행 노드의 끝은 null로, 추가한 노드의 끝은 후행 노드의 링크를 넣어준다.
        prevNode.next = null;
        prevNode.next = newNode;
        newNode.next = nextNode;
        size++;  //Node 추가 시에 항상 size 1씩 증가
    }
    
/*
    remove Method
*/
    public E remove() {
        Node<E> headNode = head;
        if(headNode == null) {
            throw new NoSuchElementException();
        }

        E element = headNode.data;   //삭제할 노드를 반환하기 위한 임시 변수

        Node<E> nextNode = headNode.next;
        head.data = null;
        head.next = null;

        head = nextNode;
        size--;

        //삭제된 요소가 리스트의 유일한 요소였을 경우 (삭제 이후 size가 0이 된다면)
        if(size == 0) {
            tail = null;
        }

        return element;
    }

    // 특정 인덱스를 넘겨 받아 해당 위치의 값을 삭제하는 경우
    @Override
    public E remove(int index) {
        if(index == 0) {
            return remove();
        }

        if(index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        Node<E> prevNode = search(index-1);
        Node<E> removeNode = prevNode.next;
        Node<E> nextNode = removeNode.next;

        E element = removeNode.data;   //return값

        prevNode.next = nextNode;  //3개의 노드에서 삭제하고자 한 중간의 노드에 걸린 링크 제거

        if(prevNode.next == null) {   //삭제한 노드가 마지막인 경우
            tail = prevNode;
        }

        removeNode.next = null;
        removeNode.data = null;
        size--;

        return element;
    }
    
    //특정 요소의 값을 직접 넘겨받아 삭제하는 경우
    @Override
    public boolean remove(Object value) {
        Node<E> prevNode = head;   //처음부터 값이 존재하는지 검사
        boolean hasValue = false;
        Node<E> x = head;

        for(; x!=null; x=x.next) {   //for문을 돌 때마다 노드는 하나씩 증가 => head부터 옆으로 이동하며 검사
            if(value.equals(x.data)) {
                hasValue = true;
                break;
            }
            prevNode = x;
        }

        if(x == null) {
            return false;
        }

        if(x.equals(head)) {
            remove();
            return true;
        } else {
            prevNode.next = x.next;   //이전 노드의 링크 삭제하려는 노드의 다음 노드로 연결

            if(prevNode.next == null) {
                tail = prevNode;
            }
            x.data = null;
            x.next = null;
            size--;
            return true;
        }
    }

/*
    get Method
*/
    @Override
    public E get(int index) {
        return search(index).data;   //노드의 데이터를 반환(search()는 노드 자체를 반환)
    }

/*
    set Method
*/
    @Override
    public void set(int index, E value) {
        Node<E> replaceNode = search(index);
        // 노드의 데이터를 교체하기 위해 인덱스를 찾고 null로 초기화한 후에 원하는 값으로 바꾼다.
        replaceNode.data = null;
        replaceNode.data = value;
    }

/*
    indexOf Method
*/
    public int indexOf(Object value) {
        int index = 0;
        for(Node<E> x = head; x!=null; x=x.next) {
            if(value.equals(x.data)) {
                return index;
            }
            index++;
        }
        return -1;  //찾고자 하는 요소가 없다면 -1을 반환
    }

/*
    contains Method
*/
    @Override
    public boolean contains(Object item) {
        return indexOf(item) >= 0;  //요소의 포함 여부를 indexOf 함수의 리턴값이 음수인지 아닌지로 판단!
    }

/*
    size Method
*/
    @Override
    public int size() {
        return size;
    }

/*
    isEmpty Method
*/
    @Override
    public boolean isEmpty() {
        return size == 0;  //size가 0이라면 비어있는 경우 true!
    }

/*
    clear Method
*/
    @Override
    public void clear() {
        for(Node<E> x = head; x != null;) {   //노드가 차례로 삭제되므로 증감식으로 접근X
            Node<E> nextNode = x.next;
            x.data = null;
            x.next = null;
            x = nextNode;
        }
        head = tail = null;
        size = 0;
    }
}

