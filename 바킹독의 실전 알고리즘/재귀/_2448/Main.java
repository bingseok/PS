package 재귀._2448;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    final static int MX = 3 * 1024 + 2;
    static char[][] board = new char[MX][2*MX-1];
    static int n;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        func(0, n-1, n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2*n - 1; j++) {
                if (board[i][j] == '*') sb.append("*");
                else sb.append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    static void fill_star(int x, int y) {
        board[x][y] = '*';
        board[x+1][y-1] = board[x+1][y+1] = '*';
        for (int i = y-2; i <= y+2; i++)
            board[x+2][i] = '*';
    }
    static void func(int x, int y, int sz) {
        if (sz == 3) {
            fill_star(x, y);
            return;
        }
        int ns = sz/2;
        func(x, y, ns);
        func(x+ns, y-ns, ns);
        func(x+ns, y+ns, ns);
    }

}
