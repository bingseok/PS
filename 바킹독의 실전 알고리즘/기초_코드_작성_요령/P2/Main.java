package 기초_코드_작성_요령.P2;

import java.util.Scanner;

public class Main {
    int[] board = new int[102];
    public boolean solution(int[] arr, int n) {
        boolean answer = false;

        for (int i = 0; i < n; i++) {
            board[arr[i]] = 1;
            if (arr[i] != 50 && board[100-arr[i]] == 1) return true;
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        System.out.print(T.solution(arr, n));
    }
}
