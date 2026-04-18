package 재귀._1992_1;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int n;
    static int[][] board = new int[65][65];

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++)
                board[i][j] = s.charAt(j) - '0';
        }

        func(0, 0, n);
        System.out.print(sb);
    }

    static void func(int r, int c, int n) {
        if (n == 0) return;
        boolean press = true;
        Loop1 : for (int i = r; i < r + n; i++) {
            for (int j= c; j < c + n; j++)
                if (board[r][c] != board[i][j]) {
                    press = false;
                    break Loop1;
                }
        }

        if (press) sb.append(board[r][c]);
        else {
            sb.append("(");
            func(r, c, n/2);
            func(r, c+n/2, n/2);
            func(r+n/2, c, n/2);
            func(r+n/2, c+n/2, n/2);
            sb.append(")");
        }
    }
}
