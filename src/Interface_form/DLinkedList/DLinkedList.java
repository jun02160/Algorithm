package Interface_form.DLinkedList;

import Interface_form.List;

import java.util.NoSuchElementException;

// 이중 연결 리스트
public class DLinkedList<E> implements List<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size;

    // 생성자
    public DLinkedList() {
        head = new Node<E>(null);
        tail = new Node<E>(null);
        this.size = 0;
    }

/*
    search Method
*/
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
    print Method
*/
    public void printE() {
        Node<E> temp = head;
        while(temp.next != null) {
            Node<E> nextNode = temp.next;
            if(nextNode.data != null) {
                System.out.print(nextNode.data);
            }
            temp = temp.next;
        }
        System.out.println();
    }

/*
    add Method
*/
    public void addLast(E value) {
        Node<E> newNode = new Node<E>(value);
        if(size == 0) {
            head.next = newNode;
            newNode.prev = head;
            tail.prev = newNode;
            newNode.next = tail;
        } else {
            tail.prev.next = newNode;
            newNode.prev = tail.prev;
            newNode.next = tail;
        }
        size++;
    }

    @Override
    public boolean add(E value) {
        addLast(value);
        return true;
    }

    @Override
    public void add(int index, E value) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node<E> newNode = new Node<E>(value);
        if(index == 0) {
            head.next.prev = newNode;
            newNode.next = head.next;
            head.next = newNode;
            newNode.prev = head;

            size++;
            return;
        }

        if(index == size-1) {
            addLast(value);
        }

        Node<E> prevNode = search(index-1);
        Node<E> nextNode = prevNode.next;

        prevNode.next = null;
        prevNode.next = newNode;
        newNode.prev = prevNode;
        newNode.next = nextNode;
        nextNode.prev = newNode;
        size++;
    }

/*
    remove Method
*/
    public void remove() {

        if(tail.prev != head) {
            tail.prev.prev.next = tail;
            tail.prev = tail.prev.prev;
        }
        size--;
    }

    @Override
    public E remove(int index) {
        Node<E> prevNode = search(index-1);
        Node<E> removeNode = prevNode.next;

        E element = removeNode.data;

        prevNode.next = removeNode.next;
        removeNode.next.prev = prevNode;

        removeNode.next = null;
        removeNode.prev = null;
        removeNode.data = null;
        size--;

        return element;
    }

    @Override
    public boolean remove(Object value) {
        Node<E> prevNode = head;
        boolean hasValue = false;
        Node<E> temp = head;

        for(; temp!=null; temp=temp.next) {
            if(value.equals(temp.data)) {
                hasValue = true;
                break;
            }
            prevNode = temp;
        }

        if(temp == null) {
            return false;
        }

        if(temp.equals(head)) {
            remove();
            return true;
        } else {
            prevNode.next = temp.next;
            temp.next.prev = prevNode;

            temp.data = null;
            temp.next = null;
            size--;
            return true;
        }

    }
/*
        get Method
*/
    @Override
    public E get(int index) {
        return search(index).data;
    }

/*
    set Method
*/
    @Override
    public void set(int index, E value) {
        Node<E> replaceNode = search(index);
        replaceNode.data = null;
        replaceNode.data = value;
    }

/*
    indexOf Method
*/
    public int indexOf(Object value) {
        int index = 0;
        for(Node<E> temp = head; temp!=null; temp = temp.next) {
            if(value.equals(temp.data)) {
                return index;
            }
            index++;
        }

        return -1;
    }


/*
    contains Method
*/
    @Override
    public boolean contains(Object item) {
        return indexOf(item) >= 0;
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
        return size == 0;
    }

/*
    clear Method
*/
    @Override
    public void clear() {
        for(Node<E> temp = head; temp!=null; ) {
            Node<E> nextNode = temp.next;

            temp.data = null;
            temp.next = null;
            temp = nextNode;
        }

        head = tail = null;
        size = 0;
    }
}
