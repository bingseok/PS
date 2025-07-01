package _01._01_02;

import java.util.Scanner;

public class Main {
    public String solution(String str) {
        String answer = "";

        // for-each 문을 활용하여 Chracter 클래스의 is/toXXCase 메서드를 사용해 대소문자 비교 및 변환
        for (char c : str.toCharArray()) {
            if (Character.isUpperCase(c)) answer += Character.toLowerCase(c);
            else answer += Character.toUpperCase(c);
        }

        // ascii 로 대소문자 변환
//        for (char c : str.toCharArray()) {
//            if (c >= 'a' && c <= 'z') answer += (char)(c - ('a' - 'A'));
//            else answer += (char)(c + ('a' - 'A'));
//        }
//
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.print(T.solution(str));
    }
}
