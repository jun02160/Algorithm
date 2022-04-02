package chap04;

// 배열로 Stack 구현하기
public class IntStack {

    private int max;     // 스택 용량
    private int ptr;     // 스택 포인터
    private int[] stk;   // 스택 본체

    public class EmptyIntStackException extends RuntimeException {
        public EmptyIntStackException() {
        }   // 스택이 비어 있는 경우, 발생시킬 예외 정의
    }

    public class OverflowIntStackException extends RuntimeException {
        public OverflowIntStackException() {
        }   // 스택이 꽉 차 있는 경우, 발생시킬 예외 정의 => 다른 메소드가 존재하지 않는 배열에 잘못 접근하는 상황 방지
    }

    // 생성자
    public IntStack(int capacity) {
        ptr = 0;
        max = capacity;  // 객체 생성 시 넘겨준 값으로 용량을 초기화
        try {
            stk = new int[max];  // 스택으로 구현할 int형 배열 선언
        } catch (OutOfMemoryError e) {
            max = 0;
        }
    }

    // push : 추가
    public int push(int x) throws OverflowIntStackException {
        if (ptr >= max)  // 스택이 꽉 차있는 경우
            throw new OverflowIntStackException();
        return stk[ptr++] = x;   // 스택포인터 ptr 1 증가
    }

    // pop : 삭제
    public int pop() throws EmptyIntStackException {
        if (ptr <= 0)  // 스택이 비어 있는 경우
            throw new EmptyIntStackException();
        return stk[--ptr];    // 스택포인터 ptr 1 감소
    }

    // peek : 꼭대기 탐색
    public int peek() throws EmptyIntStackException {
        if (ptr <= 0)
            throw new EmptyIntStackException();
        return stk[ptr - 1];
    }

    // indexOf : 값의 인덱스 검색
    public int indexOf(int x) {
        for (int i = ptr - 1; i >= 0; i--) {
            if (stk[i] == x)
                return i;  // 검색한 값이 포함된 경우 해당 인덱스 값 반환
        }
        return -1;  // 검색이 실패한 경우
    }

    // clear : 모두 삭제
    public void clear() {
        ptr = 0;  // 스택 포인터의 값만 바꾸어주면 됨 *스택 포인터는 항상 꼭대기 데이터 + 1을 가리키기 때문
    }
    
    // capacity : 용량 확인
    public int capacity() {
        return max;
    }
    
    // size : 데이터 수 확인
    public int size() {
        return ptr;   // 스택 포인터의 값 = 배열에 채워진 모든 요소의 개수
    }

    // isEmpty : 스택이 비어 있는지 확인
    public boolean isEmpty() {
        return ptr <= 0;
    }

    // isFull : 스택이 꽉 차 있는지 확인
    public boolean isFull() {
        return ptr >= max;
    }

    // dump : 스택 안의 모든 데이터 출력 (bottom -> top 순서)
    public void dump() {
        if (ptr <= 0)
            System.out.println("스택이 비어 있습니다.");
        else {
            for (int i=0; i<ptr; i++)
                System.out.print(stk[i] + " ");
            System.out.println();
        }
    }

}
    

