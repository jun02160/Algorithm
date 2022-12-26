package Do_it_자료구조와_함께_배우는_알고리즘_입문_JAVA.chap03;

// 제네릭 클래스의 예
class GenericClassTester {

    // 제네릭 클래스의 파라미터 = T
    static class GenericClass<T> {
        private T xyz;
        GenericClass(T t) {
            this.xyz = t;
        }
        T getXyz() {
            return xyz;
        }
    }

    public static void main(String[] args) {
        GenericClass<String> s = new GenericClass<String>("ABC");
        GenericClass<Integer> n = new GenericClass<Integer>(15);

        System.out.println(s.getXyz());
        System.out.println(n.getXyz());
    }
}
