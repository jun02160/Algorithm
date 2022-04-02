package chap04;

// 배열로 큐 구현하기
public class IntArrayQueue {
    private int max;     // 큐 용량
    private int num;     // 현재 데이터 수
    private int[] que;   // 큐 본체


    public class EmptyIntQueException extends RuntimeException {
        public EmptyIntQueException() {
        }   // 큐가 비어 있는 경우, 발생시킬 예외 정의
    }

    public class OverflowIntQueException extends RuntimeException {
        public OverflowIntQueException() {
        }   // 큐가 꽉 차 있는 경우, 발생시킬 예외 정의 => 다른 메소드가 존재하지 않는 배열에 잘못 접근하는 상황 방지
    }


    // 생성자
    public IntArrayQueue(int capacity) {
        num = 0;
        max = capacity;  // 객체 생성 시 넘겨준 값으로 용량을 초기화
        try {
            que = new int[max];  // 스택으로 구현할 int형 배열 선언
        } catch (OutOfMemoryError e) {
            max = 0;
        }
    }

    // enqueue : 추가
    public int enqueue(int x) throws IntArrayQueue.OverflowIntQueException {
        if (num >= max)  // 스택이 꽉 차있는 경우
            throw new IntArrayQueue.OverflowIntQueException();
        return que[num++] = x;   // 큐의 전체 개수 1증가 => 인덱스에 대응
    }

    // dequeue : 삭제
    public int dequeue() throws IntArrayQueue.EmptyIntQueException {
        if (num <= 0)  // 큐가 비어 있는 경우
            throw new IntArrayQueue.EmptyIntQueException();
        else {
            int pop = que[0];
            for (int i = 0; i < num-1; i++) {
                int temp = que[i+1];
                que[i] = que[i+1];
            }
            num--;
            return pop;  // 가장 앞에 있는 값 삭제
        }
    }

    // peek : rear의 값 탐색
    public int peek() throws IntArrayQueue.EmptyIntQueException {
        if (num <= 0)
            throw new IntArrayQueue.EmptyIntQueException();
        return que[num - 1];
    }

    // indexOf : 값의 인덱스 검색
    public int indexOf(int x) {
        for (int i = num - 1; i >= 0; i--) {
            if (que[i] == x)
                return i;  // 검색한 값이 포함된 경우 해당 인덱스 값 반환
        }
        return -1;  // 검색이 실패한 경우
    }

    // clear : 모두 삭제
    public void clear() {
        num = 0;
    }

    // capacity : 용량 확인
    public int capacity() {
        return max;
    }

    // size : 데이터 수 확인
    public int size() {
        return num;   // 스택 포인터의 값 = 배열에 채워진 모든 요소의 개수
    }

    // isEmpty : 큐가 비어 있는지 확인
    public boolean isEmpty() {
        return num <= 0;
    }

    // isFull : 큐가 꽉 차 있는지 확인
    public boolean isFull() {
        return num >= max;
    }

    // dump : 큐 안의 모든 데이터 출력 (front -> rear 순서)
    public void dump() {
        if (num <= 0)
            System.out.println("큐가 비어 있습니다.");
        else {
            for (int i=0; i<num; i++)
                System.out.print(que[i] + " ");
            System.out.println();
        }
    }
}
