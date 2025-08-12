package BFS_연습문제._10026;

import java.util.*;
import java.io.*;

public class Main_1 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static char[][] board = new char[102][102];
    static int[][] vis = new int[102][102];
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n;

    static int area() {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (vis[i][j] == 0) {
                    cnt++;
                    bfs(i, j);
                }
            }
        }
        return cnt;
    }

    static void bfs(int i, int j) {
        Queue<Pair> Q = new ArrayDeque<>();
        Q.add(new Pair(i, j));
        vis[i][j] = 1;
        while (!Q.isEmpty()) {
            Pair cur = Q.peek(); Q.remove();
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if (board[nx][ny] != board[cur.x][cur.y] || vis[nx][ny] != 0) continue;
                Q.add(new Pair(nx, ny));
                vis[nx][ny] = 1;
            }
        }
    }

    public static void main(String[] ags) throws IOException {
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < n; j++)
                board[i][j] = tmp.charAt(j);
        }

        System.out.print(area() + " ");

        for (int i = 0; i < n; i++)
            Arrays.fill(vis[i], 0);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'R') board[i][j] = 'G';
            }
        }

        System.out.print(area());
    }

    static class Pair {
        int x; int y;
        Pair(int x, int y) {
            this.x = x; this.y = y;
        }
    }
}
