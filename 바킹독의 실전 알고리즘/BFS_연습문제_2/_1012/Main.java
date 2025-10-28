package BFS_연습문제_2._1012;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] board = new int[52][52];
    static int[][] vis = new int[52][52];
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int t, m, n, k, x, y;

    public static void main(String[] args) throws IOException {
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken()); // 가로 길이
            n = Integer.parseInt(st.nextToken()); // 세로 길이
            k = Integer.parseInt(st.nextToken());
            while (k-- > 0) {
                st = new StringTokenizer(br.readLine());
                y = Integer.parseInt(st.nextToken());
                x = Integer.parseInt(st.nextToken());
                board[x][y] = 1;
            }

            System.out.println(bfs());

            for (int i = 0; i < n; i++) {
                Arrays.fill(board[i], 0, m,0);
                Arrays.fill(vis[i], 0, m, 0);
            }
        }
    }

    static int bfs() {
        int ans = 0;
        Queue<Pair> Q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 1 && vis[i][j] == 0) {
                    ans++;
                    Q.add(new Pair(i, j));
                    vis[i][j] = 1;

                    while (!Q.isEmpty()) {
                        Pair cur = Q.peek(); Q.remove();
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
        return ans;
    }
    static class Pair {
        int x, y;
        Pair(int x, int y) {
            this.x = x; this.y= y;
        }
    }
}
