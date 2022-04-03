package chap04;

// 링 버퍼로 큐 구현하기
public class IntQueue {
    private int max;    // 큐의 용량(=최대 저장가능한 요소 개수)
    private int front;  // 첫 번째 요소의 커서 (첫 번째 데이터의 인덱스)
    private int rear;   // 마지막 요소의 커서 (마지막 데이터의 인덱스 + 1)
    private int num;    // 현재 데이터 수
    private int[] que;  // 큐 본체 -> 배열 내에서 가리키는 인덱스 위치가 바뀌는 것으로 구현

    public class EmptyIntQueueException extends RuntimeException {
        public EmptyIntQueueException() {    // front = 0, rear = 0일 때
        }   // 큐가 비어 있는 경우, 발생시킬 예외 정의
    }

    public class OverflowIntQueueException extends RuntimeException {
        public OverflowIntQueueException() {  // front = rear로, 같아질 때 즉 서로 배열 내에서 위치가 겹쳐질 때
        }   // 큐가 꽉 차 있는 경우, 발생시킬 예외 정의 => 다른 메소드가 존재하지 않는 배열에 잘못 접근하는 상황 방지
    }

    // 생성자
    public IntQueue(int capacity) {
        num = front = rear = 0;
        max = capacity;
        try {
            que = new int[max];
        } catch (OutOfMemoryError e) {
            max = 0;
        }
    }

    // enqueue : 데이터 추가 (to rear)
    public int enque(int x) throws OverflowIntQueueException {
        if (num >= max)  // 큐가 꽉 차서 넘치는 경우
            throw new OverflowIntQueueException();
        // 추가되면서 마지막 요소+1을 가리키는 rear와 요소 전체 개수를 나타내는 num을 1씩 증가시킨다.
        que[rear++] = x;
        num++;
        if(rear == max)  // 배열 내에서 순회하는 방식이므로, 배열의 끝에 다다르면 다시 처음부터 시작하여 가리킨다.
            rear = 0;
        return x;
    }

    // dequeue : 데이터 삭제 (from front)
    public int deque() throws EmptyIntQueueException {
        if (num <= 0)  // 큐가 비어 있는 경우
            throw new EmptyIntQueueException();
        // 삭제되면서 첫 번째 요소를 가리키는 front(front는 그 다음 순서를 첫 번째로 지칭)와 요소 전체 개수를 나타내는 num을 1씩 증가시킨다.
        int x = que[front++];
        num--;
        if(front == max)
            front = 0;
        return x;
    }

    // peek : front의 데이터를 읽기
    public int peek() throws EmptyIntQueueException {
        if (num <= 0)
            throw new EmptyIntQueueException();
        return que[front];
    }

    // indexOf : 원하는 값의 인덱스 탐색(front부터 검사)
    public int indexOf(int x) {
        for (int i=0; i<num; i++) {
            int idx = (i+front) % max;
            if (que[idx] == x)
                return idx;
        }
        return -1;
    }
    
    // clear : 모든 요소 삭제
    public void clear() {
        num = front = rear = 0;  // 인덱스를 가리키는 front, rear와 요소의 총 개수인 num을 0으로 초기화
    }

    // capacity : 용량 확인
    public int capacity() {
        return max;
    }

    // size : 데이터 수 확인
    public int size() {
        return num;   
    }

    // isEmpty : 큐가 비어 있는지 확인
    public boolean isEmpty() {
        return num <= 0;
    }

    // isFull : 큐가 꽉 차 있는지 확인
    public boolean isFull() {
        return num >= max;
    }

    // dump : 큐 안의 모든 데이터 출력 (front->rear 순서)
    public void dump() {
        if (num <= 0)
            System.out.println("스택이 비어 있습니다.");
        else {
            for (int i=0; i<num; i++)
                System.out.print(que[i] + " ");
            System.out.println();
        }
    }

    // search : 임의의 데이터 검색
    public int search(int x) {
        int result = 1;
        int i;
        if(front < rear) {
            for(i = front; i<rear; i++) {
                if(i == indexOf(x))
                    break;
                result++;
            }
        } else {
            for (i = front; i < max; i++) {
                result++;
            }

            for (i = 0; i < rear; i++) {
                if (i == indexOf(x))
                    break;
                result++;
            }
        }

        return result;
    }

}

