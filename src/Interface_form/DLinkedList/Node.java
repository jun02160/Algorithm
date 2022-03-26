package Interface_form.DLinkedList;

class Node<E> {
    E data;
    Node<E> next;
    Node<E> prev;

    // 생성자
    public Node(E data){
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
