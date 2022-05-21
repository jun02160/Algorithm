package chap11;



// 체인법에 의한 해시
public class ChainHash<K, V> {

    // 해시를 구성하는 노드 (개별 버킷)
    class Node<K, V> {
        private K key;   // 키 값
        private V data;  // 데이터
        private Node<K, V> next;  // 다음 노드에 대한 링크 필드

        // 생성자
        Node(K key, V data, Node<K, V> next) {
            this.key = key;
            this.data = data;
            this.next = next;
        }

        // 키 값 반환
        K getKey() {
            return key;
        }

        // 데이터 값 반환
        V getValue() {
            return data;
        }

        // 키와 해시 값 반환
        public int hashCode() {
            return key.hashCode();
        }
    }


    private int size;
    private Node<K, V>[] table;

    // 생성자
    public ChainHash(int capacity) {
        try {
            table = new Node[capacity];
            this.size = capacity;
        } catch (OutOfMemoryError e) {
            this.size = 0;  // 메모리 확보 실패 시 size를 0으로 준다.
        }
    }

    // 해시 값을 구함
    public int hashValue(Object key) {
        return key.hashCode() % size;
    }

    // key을 갖는 요소의 검색(데이터 반환)
    public V search(K key) {
        int hash = hashValue(key);   // 검색할 데이터의 해시 값
        Node<K, V> p = table[hash];   // 선택 노드

        while (p != null) {
            if (p.getKey().equals(key))  // 검색 성공
                return p.getValue();
            p = p.next;  // 노드 전진
        }
        return null;
    }

    // key, data를 갖는 요소의 추가
    public int add(K key, V data) {
        int hash = hashValue(key);  // 추가할 데이터의 해시 값
        Node<K, V> p = table[hash];

        while (p != null) {
            if (p.getKey().equals(key))
                return 1;
            p = p.next;
        }

        Node<K, V> temp = new Node<K, V>(key, data, table[hash]);
        table[hash] = temp;   // 노드 삽입
        return 0;
    }
    
    // key를 갖는 요소의 삭제
    public int remove(K key) {
        int hash = hashValue(key);   // 삭제될 데이터의 해시 값
        Node<K, V> p = table[hash];  // 선택 노드 
        Node<K, V> prev = null;        // 선택 노드 이전의 노드
        
        while (p != null) {
            if (p.getKey().equals(key)) {
                if (prev == null)
                    table[hash] = p.next;
                else
                    prev.next = p.next;
                return 0;
            }

            prev = p;
            p = p.next;
        }
        return 1;
    }

    // 해시 테이블로 덤프
    public void dump() {
        for (int i=0; i<size; i++) {
            Node<K, V> p = table[i];
            System.out.printf("%02d  ", i);
            while (p != null) {
                System.out.printf(" -> %s  (%s)  ", p.getKey(), p.getValue());
                p = p.next;
            }

            System.out.println();
        }
    }
}
