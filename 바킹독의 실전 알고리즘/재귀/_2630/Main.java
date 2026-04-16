package 재귀._2630;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n;
    static int[][] board = new int[130][130];
    static int[] arr = new int[2];

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++)
                board[i][j] = Integer.parseInt(st.nextToken());
        }

        func(0, 0, n);
        for (int i : arr) System.out.println(i);
    }

    static void func(int r, int c, int n) {
        if (check(r, c, n))
            arr[board[r][c]]++;
        else {
            int z = n/2;
            for (int i = 0; i < 2; i++)
                for (int j = 0; j < 2; j++)
                    func(r + i*z, c + j*z, z);
        }
    }

    static boolean check(int r, int c, int n) {
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (board[r+i][c+j] != board[r][c]) return false;
        return true;
    }

}
