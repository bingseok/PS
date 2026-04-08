package BFS_연습문제._2573;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int n, m;
    static int[][] board = new int[302][302];
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

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

        int year = 0;
        while (true) {
            int ans = bfs();
            if (ans >= 2) {
                System.out.print(year);
                return;
            }
            if (ans == 0) {
                System.out.print(0);
                return;
            }
            melting();
            year++;
        }
    }

    static int bfs() {
        int ans = 0;
        int[][] vis = new int[n][m];
        for (int i = 0; i < n; i++) Arrays.fill(vis[i], 0, m, 0);
        Queue<Pair> Q = new ArrayDeque<>();
        for (int i = 1; i < n-1; i++) {
            for (int j = 1; j < m-1; j++) {
                if (board[i][j] != 0 && vis[i][j] == 0) {
                    ans++;
                    vis[i][j] = 1;
                    Q.add(new Pair(i, j));
                    while (!Q.isEmpty()) {
                        Pair cur = Q.peek(); Q.remove();
                        for (int dir = 0; dir < 4; dir++) {
                            int nx = cur.x + dx[dir];
                            int ny = cur.y + dy[dir];
                            if (board[nx][ny] == 0 || vis[nx][ny] != 0) continue;
                            vis[nx][ny] = 1;
                            Q.add(new Pair(nx, ny));
                        }
                    }
                }
            }
        }
        return ans;
    }


    static void melting() {
        int[][] tmp = new int[n][m];
        for (int i = 0; i < n; i++) Arrays.fill(tmp[i], 0, m, 0);
        for (int i = 1; i < n-1; i++) {
            for (int j = 1; j < m-1; j++) {
                if (board[i][j] != 0) {
                    int melt = 0;
                    for (int dir = 0; dir < 4; dir++) {
                        int nx = i + dx[dir];
                        int ny = j + dy[dir];
                        if (board[nx][ny] == 0) melt++;
                    }
                    tmp[i][j] = Math.max(0, board[i][j] - melt);
                }
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