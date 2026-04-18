package 재귀._2447;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int n;
    final static int MX = (int)Math.pow(3, 7);
    static char[][] board = new char[MX+2][MX+2];

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) Arrays.fill(board[i], 0, n, ' ');

        func(0, 0, n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(board[i][j]);
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }

    static void func(int r, int c, int n) {
        if (n == 1) {
            board[r][c] = '*';
            return;
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) continue;
                func(r + i * n/3,  c + j * n/3, n/3);
            }
        }
    }
}
