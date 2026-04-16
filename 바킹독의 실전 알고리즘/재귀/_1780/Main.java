package 재귀._1780;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int n;
    static int[][] board;
    static int[] arr = new int[3];

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        board = new int[n+1][n+1];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken()) + 1;
            }
        }

        func(0, 0, n);
        for (int i : arr) System.out.println(i);
    }

    static void func(int r, int c, int n) {
        if (check(r, c, n)) {
            arr[board[r][c]]++;
            return;
        }
        int k = n / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                func(r + i*k, c + j*k, k);
            }
        }
    }

    static boolean check(int r, int c, int n) {
        boolean check = true;
        int start = board[r][c];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[r + i][c + j] != start)
                    return false;
            }
        }
        return true;
    }




}
