package BFS_연습문제_2._2573;

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] board = new int[301][301];
    static int[][] vis = new int[301][301];
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n, m, year;

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

        while (true) {
            for (int i = 0; i < n; i++) Arrays.fill(vis[i], 0, m, 0);
            int ans = bfs();
            if (ans == 0) {
                System.out.print(0); return;
            }
            if (ans >= 2) {
                System.out.print(year); return;
            }
            melting();
            year++;
        }
    }

    static int bfs() {
        int cnt = 0;
        Queue<Pair> Q = new ArrayDeque<>();
        for (int i = 1; i < n-1; i++) {
            for (int j = 1; j < m-1; j++) {
                if (board[i][j] != 0 && vis[i][j] == 0) {
                    Q.add(new Pair(i, j));
                    vis[i][j] = 1;
                    cnt++;
                    while (!Q.isEmpty()) {
                        var cur = Q.peek(); Q.remove();
                        for (int dir = 0; dir < 4; dir++) {
                            int x = cur.x + dx[dir];
                            int y = cur.y + dy[dir];
                            if (x < 0 || x >= n || y < 0 || y >= m) continue;
                            if (board[x][y] == 0 || vis[x][y] != 0) continue;
                            Q.add(new Pair(x, y));
                            vis[x][y] = 1;
                        }
                    }
                }
            }
        }
        return cnt;
    }

    static void melting() {
        int[][] tmp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] != 0) {
                    int ice = 0;
                    for (int dir = 0; dir < 4; dir++) {
                        int x = i + dx[dir];
                        int y = j + dy[dir];
                        if (board[x][y] == 0) ice++;
                    }
                    tmp[i][j] = Math.max(0, board[i][j] - ice);
                }
                else tmp[i][j] = 0;
            }
        }
        board = tmp;
    }

    static class Pair {
        int x, y;
        Pair(int x, int y) {
            this.x = x; this.y = y;
        }
    }
}
