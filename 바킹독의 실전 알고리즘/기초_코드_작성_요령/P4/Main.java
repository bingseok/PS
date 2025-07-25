package 기초_코드_작성_요령.P4;

import java.util.Scanner;

public class Main {

    public int solution(int n) {
        int answer = 1;

        while (answer * 2 <= n) {
            answer *= 2;
        }
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.print(T.solution(n));
    }
}
