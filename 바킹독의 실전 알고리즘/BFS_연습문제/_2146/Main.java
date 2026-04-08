package BFS_연습문제._2146;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    final static int MX = 102;
    static int[][] vis = new int[MX][MX];
    static int[][] board = new int[MX][MX];
    static int[][] dist = new int[MX][MX];
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Queue<Pair> Q = new ArrayDeque<>();
    static int n, ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] != 0 && vis[i][j] == 0) {
                    vis[i][j] = 1;
                    Q.add(new Pair(i, j));
                    while (!Q.isEmpty()) {
                        Pair cur = Q.peek(); Q.remove();
                        board[cur.x][cur.y] = cnt;
                        for (int dir = 0; dir < 4; dir++) {
                            int nx = cur.x + dx[dir];
                            int ny = cur.y + dy[dir];
                            if (OOB(nx, ny)) continue;
                            if (vis[nx][ny] != 0 || board[nx][ny] == 0) continue;
                            vis[nx][ny] = 1;
                            Q.add(new Pair(nx, ny));
                        }
                    }
                }
                cnt++;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] != 0) bfs(i, j);
            }
        }

        System.out.print(ans);
    }

    static void bfs(int x, int y) {
        Q.clear();
        for (int i = 0; i < n; i++) Arrays.fill(dist[i], 0, n, -1);

        dist[x][y] = 0;
        Q.add(new Pair(x, y));
        while (!Q.isEmpty()) {
            Pair cur = Q.peek(); Q.remove();
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                if (OOB(nx, ny)) continue;
                if (dist[nx][ny] != -1 || board[nx][ny] == board[x][y]) continue;
                if (board[nx][ny] != 0 && board[nx][ny] != board[x][y]) {
                    ans = Math.min(ans, dist[cur.x][cur.y]);
                    return;
                }
                dist[nx][ny] = dist[cur.x][cur.y] + 1;
                Q.add(new Pair(nx, ny));
            }
        }

    }
    static boolean OOB(int nx, int ny) {
        return nx < 0 || nx >= n || ny < 0 || ny >= n;
    }
    static class Pair {
        int x, y;
        Pair(int x, int y) {
            this.x = x; this.y = y;
        }
    }

}

