package 재귀._1992;

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
        System.out.print(func(0, 0, n));
    }

    static String func(int r, int c, int n) {
        // if) n이 압축되면 -> (1)
        // else) n이 입축안되면 -> (func func func func)
        // 크기가 1이면 압축이 된다.
        // 크기가 k일 때 압축 결과를 알면, k+1일때의 결과를 알 수 있다.
        if (n == 0) return "";
        // 크기가 n일 때의 압축 결과
        boolean press = true;
        Loop1: for (int i = r; i < r + n; i++) {
            for (int j = c; j < c + n; j++) {
                if (board[r][c] != board[i][j]) {
                    press = false;
                    break Loop1;
                }
            }
        }

        String res = "";
        int half = n/2;
        if (press) { // 압축이 될 때
            res = board[r][c] + "";
            return res;
        }
        else { // 압축이 안될 때
            res = "(" + func(r, c, half) + func(r, c+half, half)
                    + func(r+half, c, half) + func(r+half, c+half, half) + ")";
            return res;
        }
    }
}
