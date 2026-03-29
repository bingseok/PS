package BFS_연습문제._1926;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[][] board = new int[502][502];
    static int[][] vis = new int[502][502];
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Deque<Pair> Q = new ArrayDeque<>();
    static int n, m;
    static int cnt, mx;

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

        System.out.print(cnt + "\n" + mx);
    }

    static void bfs(int i, int j) {
        int size = 0;
        cnt++;
        vis[i][j] = 1;
        Q.add(new Pair(i, j));
        while (!Q.isEmpty()) {
            Pair cur = Q.peek();
            Q.remove(); size++;
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                if (OOB(nx, ny)) continue;
                if (board[nx][ny] != 1 || vis[nx][ny] != 0) continue;
                vis[nx][ny] = 1;
                Q.add(new Pair(nx, ny));
            }
        }

        mx = Math.max(mx, size);
    }

    static boolean OOB(int nx, int ny) {
        return nx < 0 || nx >= n || ny < 0 || ny >= m;
    }
    static class Pair {
        int x, y;
        Pair(int x, int y) {
            this.x = x; this.y = y;
        }
    }
}
