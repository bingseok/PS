package BFS_연습문제._10026;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static char[][] board = new char[105][105];
    static int[][] vis = new int[105][105];
    static Queue<Pair> Q = new ArrayDeque<>();
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                board[i][j] = s.charAt(j);
            }
        }

        int res1 = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (vis[i][j] == 0) {
                    res1++;
                    bfs(i, j);
                }
            }
        }

        int res2 = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'G') board[i][j] = 'R';
            }
        }

        Q.clear();
        for (int i = 0; i < n; i++) Arrays.fill(vis[i], 0, n, 0);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (vis[i][j] == 0) {
                    res2++;
                    bfs(i, j);
                }
            }
        }

        System.out.print(res1 + " " + res2);
    }

    static void bfs(int i, int j) {
        vis[i][j] = 1;
        Q.add(new Pair(i, j));
        while (!Q.isEmpty()) {
            Pair cur = Q.peek(); Q.remove();
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                if (OOB(nx, ny)) continue;
                if (board[nx][ny] != board[cur.x][cur.y] || vis[nx][ny] != 0) continue;
                vis[nx][ny] = 1;
                Q.add(new Pair(nx, ny));
            }
        }
    }

    static boolean OOB(int x, int y) {
        return x < 0 || x >= n || y < 0 || y >= n;
    }
    static class Pair {
        int x, y;
        Pair(int x, int y) {
            this.x = x; this.y = y;
        }
    }

}
