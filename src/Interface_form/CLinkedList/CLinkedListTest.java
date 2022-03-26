package Interface_form.CLinkedList;

public class CLinkedListTest {
    public static void main(String[] args) {
        CLinkedList<Integer> list = new CLinkedList<>();
        list.addFront(1);
        list.addBack(3);
        list.addBack(5);

        list.remove(3);

        System.out.println(list.size());
        list.clear();
        System.out.println(list.size());
    }
}
