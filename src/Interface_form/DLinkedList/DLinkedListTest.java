package Interface_form.DLinkedList;

public class DLinkedListTest {

    public static void main(String[] args) {
        DLinkedList<Integer> list = new DLinkedList<>();
        list.addLast(1);
        list.add(3);
        list.add(0, 5);
        list.addLast(5);

        for(int i=0; i<list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }

        System.out.println();
        System.out.print(list.contains(3) + " ");
        System.out.print(list.contains(4));
        System.out.println();

        list.clear();
        System.out.println(list.size());
    }

}
