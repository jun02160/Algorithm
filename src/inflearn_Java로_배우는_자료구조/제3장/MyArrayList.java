package inflearn_Java로_배우는_자료구조.제3장;

import java.util.Arrays;

public class MyArrayList<E> {

    private static final int INIT_CAPACITY = 10;
    private E [] theData;
    private int size;
    private int capacity = 0;

    public MyArrayList() {
        theData = (E[]) new Object[INIT_CAPACITY];  // 정해지지 않은 타입 E에 대한 배열을 생성할 수 없다. => Object형으로 생성 후 type casting 해주는 것이 일단은 최선
        size = 0;
    }

    public void add(int index, E anEntry) {
        if (index < 0 || index > size) {  // 요청 값이 잘못 되었음을 알리기 위해 void 대신 boolean 을 반환하도록 구현할 수 있다.
            throw new ArrayIndexOutOfBoundsException(index);  // Exception Handling 을 이용하는 게 가장 자바스러운 구현방식
        }

        if (size >= capacity) {
            reallocate();
        }

        for (int i=size-1; i>=index; i--) {
            theData[i+1] = theData[i];  // add한 위치 뒤부터 한 칸씩 밀어준다
        }
        theData[index] = anEntry;
    }

    public void add(E enEntry) {
        add(size, enEntry);
    }

    private void reallocate() {
        capacity *= 2;  // 배열의 공간이 부족하다면, 2배만큼 용량을 늘려준다.
        theData = Arrays.copyOf(theData, capacity);
    }

    public int size() {
        return size;
    }

    public int indexOf(E anEntry) {
        for (int i=0; i<size; i++) {
            if (theData[i].equals(anEntry))
                return i;
        }
        return -1;
    }

    public E get(int index) {
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException(index);  // Exception Handling 을 이용하는 게 가장 자바스러운 구현방식
        }

        return theData[index];
    }

    public E set(int index, E newValue) {
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException(index);  // Exception Handling 을 이용하는 게 가장 자바스러운 구현방식
        }

        E oldValue = theData[index];
        theData[index] = newValue;
        return oldValue;
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException(index);  // Exception Handling 을 이용하는 게 가장 자바스러운 구현방식
        }

        E returnValue = theData[index];
        for (int i=index+1; i<size; i++) {
            theData[i-1] = theData[i];  // 삭제한 위치를 기준으로 뒤에 오는 원소들을 하나씩 앞 칸으로 당겨준다.
        }
        size--;
        return returnValue;
    }
}
