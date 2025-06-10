package _01_01;

import java.util.Scanner;

public class Main {
    public int solution(String input, char c) {
        int answer = 0;

        // String 소문자로 변환
        input = input.toLowerCase();

        // char을 소문자로 변환 -> Character 클래스의 toLowerCase() 메서드
        c = Character.toLowerCase(c);

        for (int i = 0; i < input.length(); i++) {
            // String의 index 접근
            if (input.charAt(i) == c) answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        char c = sc.next().charAt(0);
        System.out.println(T.solution(input, c));
    }
}
