package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _1181 {
    
    // 중복되는 단어는 삭제하는 메소드
    static ArrayList<String> listToSet(ArrayList<String> arr) {
        HashSet<String> wordset = new HashSet<>(arr);
        ArrayList<String> newlist = new ArrayList<>(wordset);

        return newlist;
    }

    static void printList(ArrayList<String> arr) {
        for(int i=0; i<arr.size(); i++) {
            System.out.println(arr.get(i));
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<String> wordlist = new ArrayList<String>();
        ArrayList<String> onelist;

        for(int i=0; i<N; i++) {
            wordlist.add(br.readLine());
        }

        onelist = listToSet(wordlist);

        // 정렬 조건 1 - 길이가 더 작은 단어
        Comparator<String> wordlength = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        };

        // 정렬 조건 2 - 사전 순
        Comparator<String> worddic = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        };

        // 우선순위일수록 나중에 작성하여 최종적으로는 첫째조건이 적용되도록 한다.
        onelist.sort(worddic);
        onelist.sort(wordlength);

        printList(onelist);
    }
}
