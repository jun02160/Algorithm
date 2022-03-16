package Interface_form;

public class SLinkedListTest {
    public static void main(String[] args) {
        SLinkedList<Integer> list = new SLinkedList<>();
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
