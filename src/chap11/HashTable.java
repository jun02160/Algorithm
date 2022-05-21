package chap11;

import java.util.HashMap;
import java.util.LinkedList;

public class HashTable {
    class Node {
        String key;
        String value;
        public Node(String key, String value) {
            this.key = key;
            this.value = value;
        }

        String value() {
            return value;
        }

        void value(String value) {
            this.value = value;
        }
    }

    // 연결 리스트 선언
    LinkedList<Node> [] data;
    
    // 해시 테이블을 연결 리스트로 구현
    public void hashTable(int size) {
        this.data = new LinkedList[size];
    }

    // key 값을 통해 hashcode 생성 - 아스키 코드 이용
    int getHashCode(String key) {
        int hashcode = 0;
        for (char c : key.toCharArray())
            hashcode += c;
        return hashcode;
    }

    // hashcode를 이용해서 index 지정
    int convertToIndex(int hashcode) {
        return hashcode % data.length;
    }

    // key로 원소 찾기
    Node searchKey(LinkedList<Node> list, String key) {
        if (list == null)
            return null;
        for (Node node : list) {
            if (node.key.equals(key)) {
                return node;
            }
        }
        return null;
    }
    
    // key를 통한 값 저장
    void set(String key, String value) {
        int index = convertToIndex(getHashCode(key));
        LinkedList<Node> list = data[index];
        if (list == null) {
            list = new LinkedList<Node>();
            data[index] = list;
        }

        Node node = searchKey(list, key);

        if (node == null)
            list.addLast(new Node(key, value));
        else
            node.value(value);

        System.out.println("hashcode : " + getHashCode(key) + ", index : " + index + ", ");
    }

    // key를 통한 값 호출
    String get(String key) {
        int index = convertToIndex(getHashCode(key));
        LinkedList<Node> list = data[index];

        if (list == null)
            return "Not Found";
        else {
            for (Node n : list) {
                if (n.key.equals(key))
                    return n.value;

            }
            return null;
        }
    }

    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("객체", "하");
        map.put("데구", "하하");
        map.put("기구", "하하하");

        System.out.println(map.get("객체"));
        System.out.println(map.get("데구"));
        System.out.println(map.get("기구"));
    }
}
