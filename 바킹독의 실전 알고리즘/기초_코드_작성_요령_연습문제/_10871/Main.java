package 기초_코드_작성_요령_연습문제._10871;

import java.util.*;

public class Main {
    public char solution(int n) {
        char answer = ' ';

        if (n >= 90) answer = 'A';
        else if (n >= 80) answer = 'B';
        else if (n >= 70) answer = 'C';
        else if (n >= 60) answer = 'D';
        else answer = 'F';

        return answer;
    }
    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.print(T.solution(n));
    }
}
