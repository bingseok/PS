package BFS_연습문제._1926;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[][] board = new int[505][505];
    static int[][] vis = new int[505][505];
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n, m;
    static int res, cnt;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 1 && vis[i][j] == 0) {
                    bfs(i, j);
                }
            }
        }

        System.out.print(cnt + "\n" + res);
    }

    static void bfs(int i, int j) {
        int area = 0;
        cnt++;
        Deque<Pair> Q = new ArrayDeque<>();
        vis[i][j] = 1;
        Q.add(new Pair(i, j));
        while (!Q.isEmpty()) {
            Pair cur = Q.peek(); Q.remove();
            area++;
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                if (OOB(nx, ny)) continue;
                if (board[nx][ny] != 1 || vis[nx][ny] != 0) continue;
                vis[nx][ny] = 1;
                Q.add(new Pair(nx, ny));
            }
        }

        res = Math.max(area, res);
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
