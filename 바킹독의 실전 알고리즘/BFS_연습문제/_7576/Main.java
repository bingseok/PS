package BFS_연습문제._7576;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[][] board = new int[1002][1002];
    static int[][] dist = new int[1002][1002];
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Deque<Pair> Q = new ArrayDeque<>();
    static int n, m;
    static int day;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 1) Q.add(new Pair(i, j));
                if (board[i][j] == 0) dist[i][j] = -1;
            }
        }

        bfs();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dist[i][j] == -1) {
                    System.out.print(-1);
                    return;
                }
                day = Math.max(day, dist[i][j]);
            }
        }
        System.out.print(day);
    }

    static void bfs() {
        while (!Q.isEmpty()) {
            Pair cur = Q.peek(); Q.remove();
            for (int dir = 0; dir < 4; dir++) {
                int x = cur.x + dx[dir];
                int y = cur.y + dy[dir];
                if (OOB(x, y)) continue;
                if (board[x][y] != 0 || dist[x][y] != -1) continue;
                dist[x][y] = dist[cur.x][cur.y] + 1;
                Q.add(new Pair(x, y));
            }
        }
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
