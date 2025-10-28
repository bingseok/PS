package BFS_연습문제_2._10026;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static char[][] board = new char[101][101];
    static int[][] vis = new int[101][101];
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        // 입력 받기
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < n; j++) {
                board[i][j] = input.charAt(j);
            }
        }

        int ans1 = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (vis[i][j] == 0) {
                    bfs(i, j);
                    ans1++;
                }
            }
        }

        for (int i = 0; i < n; i++) Arrays.fill(vis[i], 0, n,0);

        int ans2 = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'R') board[i][j] = 'G';
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (vis[i][j] == 0) {
                    bfs(i, j);
                    ans2++;
                }
            }
        }

        System.out.print(ans1 + " " + ans2);
    }

    static void bfs(int i, int j) {
        Queue<Pair> Q = new ArrayDeque<>();
        Q.add(new Pair(i, j));
        vis[i][j] = 1;

        while (!Q.isEmpty()) {
            Pair cur = Q.peek(); Q.remove();
            for (int dir = 0; dir < 4; dir++) {
                int x = cur.x + dx[dir];
                int y = cur.y + dy[dir];
                if (x < 0 || x >= n || y < 0 || y >= n) continue;
                if (board[x][y] != board[cur.x][cur.y] || vis[x][y] != 0) continue;
                Q.add(new Pair(x, y));
                vis[x][y] = 1;
            }
        }
    }

    static class Pair {
        int x, y;
        Pair(int x, int y) {
            this.x = x; this.y = y;
        }
    }
}
