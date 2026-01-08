package 재귀._1780;

import java.util.*;
import java.io.*;

public class Main {
    final static int SZ = (int)Math.pow(3, 7);
    static int[][] board = new int[SZ][SZ];
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n;
    static int[] ans = new int[3];

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        // 배열 입력 받기
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken() + 1);
            }
        }

        run(n, 0, 0);
        for (int i = 0; i < 3; i++) System.out.println(ans[i]);
    }

    // n x n 배열에서 -1, 0, 1의 종이가 각각 몇 개인지 카운트 하는 함수
    static void run(int n, int a, int b) {
        if (n == 1) {
            ans[board[a][b]]++;
            return;
        }
        int k = board[a][b];
        boolean isSquare = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[a+i][b+j] != k) isSquare = false;
            }
        }
        if (isSquare) ans[board[a][b]]++;
        else {
            run(n/3, a, b);
            run(n/3, a, b/3);
            run(n/3, a, b/3*2);
            run(n/3, a/3, b);
            run(n/3, a/3, b/3);
            run(n/3, a/3, b/3*2);
            run(n/3, 2*a/3, b);
            run(n/3, 2*a/3, b/3);
            run(n/3, 2*a/3, b/3*2);
        }
    }
}
