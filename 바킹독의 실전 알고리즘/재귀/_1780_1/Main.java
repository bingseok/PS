package 재귀._1780_1;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n;
    static int[][] board;
    static int[] arr = new int[3];

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        run(n, 0, 0);
        for (int i : arr) System.out.println(i);
    }

    // 같은 종이로 되어있는지 확인하는 함수
    static boolean check(int n, int row, int col) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i+row][j+col] != board[row][col]) return false;
            }
        }
        return true;
    }

    static void run(int n, int row, int col) {
        // 재귀 종료 조건 -> 종이가 같은 수로 되어있을 때
        if (check(n, row, col)) {
           arr[board[row][col] + 1]++;
           return;
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                run(n/3, row + (n/3)*i, col + (n/3)*j);
            }
        }
    }
}
