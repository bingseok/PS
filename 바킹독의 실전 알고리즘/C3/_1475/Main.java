package C3._1475;

import java.util.*;

public class Main {

    public int solution(int n) {
        int answer = 0;
        int[] board = new int[10];

        while (n != 0) {
            board[n % 10]++;
            n /= 10;
        }

        board[6] = board[9] = (board[6] + board[9] + 1) / 2;

        for (int x : board) {
            answer = Math.max(answer, x);
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
