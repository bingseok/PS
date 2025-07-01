package _01._01_01;

import java.util.*;

public class Main {

    public int solution(String str, char c) {
        int answer = 0;
        str = str.toUpperCase();
        c = Character.toUpperCase(c);

        // 1. 인덱스로 접근
//        for (int i = 0; i < str.length(); i++) {
//            if (str.charAt(i) == c) answer++;
//        }

        // 2. advanced-for
        for (char t : str.toCharArray()) { // String을 char 배열로 변환
            if (t == c) answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char c = sc.next().charAt(0);
        System.out.print(T.solution(str, c));
    }
}