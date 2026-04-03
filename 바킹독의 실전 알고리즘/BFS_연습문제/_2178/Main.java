package BFS_연습문제._2178;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int n, m;
    static int[][] board = new int[102][102];
    static int[][] dist = new int[102][102];
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = s.charAt(j) - '0';
            }
        }

        Deque<Pair> Q = new ArrayDeque<>();
        dist[0][0] = 1;
        Q.add(new Pair(0, 0));
        while (!Q.isEmpty()) {
            Pair cur = Q.peek(); Q.remove();
            for (int dir = 0; dir < 4; dir++) {
                int x = cur.x + dx[dir];
                int y = cur.y + dy[dir];
                if (OOB(x, y)) continue;
                if (board[x][y] != 1 || dist[x][y] != 0) continue;
                dist[x][y] = dist[cur.x][cur.y] + 1;
                Q.add(new Pair(x, y));
            }
        }

        System.out.print(dist[n-1][m-1]);
    }

    static boolean OOB(int x, int y) {
        return x < 0 || x >= n || y < 0 || y >= m;
    }

    static class Pair {
        int x, y;
        Pair(int x, int y) {
            this.x = x; this.y = y;
        }
    }
}
