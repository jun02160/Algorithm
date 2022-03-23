package Baekjoon;

import java.io.*;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class _1406 {

    // 백준 1406 에디터
    // DoublyLinkedList
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String editor;

        editor = st.nextToken();
        st = new StringTokenizer(br.readLine());

        LinkedList<Character> list = new LinkedList<>();
        for(int i=0; i<editor.length(); i++) {
            list.add(editor.charAt(i));
        }
        ListIterator<Character> list_iter = list.listIterator();   // 맨처음과 끝을 이어주는 양방향 연결리스트
        while(list_iter.hasNext()) {
            list_iter.next();  //커서를 가장 오른쪽으로 위치
        }

        int M = Integer.parseInt(st.nextToken());
        for(int i=0; i<M; i++) {
            String commands = br.readLine();
            Character command = commands.charAt(0);

            switch (command) {
                case 'L':
                    if(list_iter.hasPrevious())
                        list_iter.previous();
                    break;

                case 'D':
                    if(list_iter.hasNext())
                        list_iter.next();
                    break;

                case 'B':
                    if(list_iter.hasPrevious()) {
                        list_iter.previous();
                        list_iter.remove();
                    }
                    break;

                case 'P':
                    Character new_word = commands.charAt(2);  // String으로 입력받으면 중간 공백은 1번째 인덱스에 속함
                    list_iter.add(new_word);
                    break;

                default:
                    break;
            }
        }

        for(Character c : list){
            bw.write(c);  //시간초과의 문제로 표준 출력 스트림을 사용한다.
        }
        bw.flush();
        bw.close();
    }
}
