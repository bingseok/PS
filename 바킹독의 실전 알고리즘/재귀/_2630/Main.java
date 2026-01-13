package 재귀._2630;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n;
    static int[][] board = new int[128][128];
    static int[] arr = new int[2];

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        run(n, 0, 0);
        for (int i : arr) System.out.println(i);
    }

    static boolean check(int n, int row, int col) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[row+i][col+j] != board[row][col]) return false;
            }
        }
        return true;
    }

    static void run(int n, int row, int col) {
        if (check(n, row, col)) {
            arr[board[row][col]]++;
            return;
        }

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                run(n/2, row + (n/2) * i, col + (n/2) * j);
            }
        }
    }
}
