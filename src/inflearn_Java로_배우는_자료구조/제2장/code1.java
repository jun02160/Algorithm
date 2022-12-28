package inflearn_Java로_배우는_자료구조.제2장;

public class code1 {

    public static void main(String[] args) {
        Person1 first;
        first = new Person1();

        first.name = "yejun";
        first.number = "010-1234-5678";

        Person1 second = new Person1();
        second.name = "yeseo";
        second.number = "010-0000-0000";

        System.out.println("Name: " + first.name + ", Number: " + first.number);
        System.out.println("Name: " + second.name + ", Number: " + second.number);


        Person1[] members = new Person1[4];
        members[0] = first;
        members[1] = second;

        System.out.println("Name: " + members[0].name + ", Number: " + members[0].number);
        System.out.println("Name: " + members[1].name + ", Number: " + members[1].number);

    }
}
