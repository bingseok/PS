package 배열_연습문제._3273;

import java.util.*;

public class Main {

    public int solution(int n, int[] arr, int x) {
        int answer = 0;
        int[] board = new int[2000005];

        for (int k : arr) {
            if (k >= x) continue;
            if (board[x - k] == 1) answer++;
            board[k] = 1;
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n; n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        int x; x = sc.nextInt();
        System.out.print(T.solution(n, arr, x));
    }
}
