package BFS_연습문제._13549;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    final static int MX = 100001;
    static int[] board = new int[MX+2];
    static Queue<Integer> Q = new ArrayDeque<>();
    static int n, k;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        board[n] = 1;
        Q.add(n);
        teleport(n);

        while (board[k] == 0) {
            int cur = Q.peek(); Q.remove();
            int[] dx = {cur+1, cur-1};
            for (int x : dx) {
                if (x < 0 || x >= MX) continue;
                if (board[x] != 0) continue;
                board[x] = board[cur] + 1;
                Q.add(x);
                teleport(x);
            }
        }

        System.out.print(board[k] - 1);
    }

    static void teleport(int n) {
        if (n == 0) return;
        int cur = n;
        while (cur <= MX && board[k] == 0) {
            if (board[cur] == 0) {
                board[cur] = board[n];
                Q.add(cur);
            }
            cur *= 2;
        }
    }

}
