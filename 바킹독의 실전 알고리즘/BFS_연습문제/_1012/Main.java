package BFS_연습문제._1012;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[][] board = new int[52][52];
    static int[][] vis = new int[52][52];
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int t, m, n, k;

    public static void main(String[] args) throws IOException {
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            while (k-- > 0) {
                st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                board[x][y] = 1;
            }

            int ans = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (board[i][j] == 1 && vis[i][j] == 0) {
                        bfs(i, j);
                        ans++;
                    }
                }
            }
            sb.append(ans).append("\n");

            for (int i = 0; i < n; i++) {
                Arrays.fill(board[i], 0, m, 0);
                Arrays.fill(vis[i], 0, m, 0);
            }
        }

        System.out.print(sb);

    }

    static void bfs(int i, int j) {
        Queue<Pair> Q = new ArrayDeque<>();
        vis[i][j] = 1;
        Q.add(new Pair(i, j));
        while (!Q.isEmpty()) {
            Pair cur = Q.peek();
            Q.remove();
            for (int dir = 0; dir < 4; dir++) {
                int x = cur.x + dx[dir];
                int y = cur.y + dy[dir];
                if (OOB(x, y)) continue;
                if (board[x][y] != 1 || vis[x][y] != 0) continue;
                vis[x][y] = 1;
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