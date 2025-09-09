package BFS_연습문제._2573;

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] board = new int[302][302];
    static int[][] vis = new int[302][302];
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n, m;
    static Queue<Pair> Q = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++)
                board[i][j] = Integer.parseInt(st.nextToken());
        }

        int year = 0;
        while (true) {
            int cnt = bfs();
            if (cnt >= 2) {
                System.out.println(year);
                return;
            }
            else if (cnt == 0) {
                System.out.println(0);
                return;
            }

            year++;
            int[][] tmp = new int[302][302];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (board[i][j] != 0) {
                        int num = 0;
                        for (int dir = 0; dir < 4; dir++) {
                            int nx = i + dx[dir];
                            int ny = j + dy[dir];
                            if (board[nx][ny] == 0) num++;
                        }
                        tmp[i][j] = Math.max(0, board[i][j] - num);
                    }
                    else tmp[i][j] = 0;
                }
            }

            board = tmp;

            for (int i = 0; i < n; i++)
                Arrays.fill(vis[i], 0);
            Q.clear();
        }
    }

    static int bfs() {
        int num = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] != 0 && vis[i][j] == 0) {
                    Q.add(new Pair(i, j));
                    vis[i][j] = 1;
                    num++;
                    while (!Q.isEmpty()) {
                        Pair cur = Q.peek();
                        Q.remove();
                        for (int dir = 0; dir < 4; dir++) {
                            int nx = cur.x + dx[dir];
                            int ny = cur.y + dy[dir];
                            if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                            if (board[nx][ny] == 0 || vis[nx][ny] != 0) continue;
                            Q.add(new Pair(nx, ny));
                            vis[nx][ny] = 1;
                        }
                    }
                }
            }
        }

        return num;
    }

    static class Pair {
        int x, y;
        Pair(int x, int y) {
            this.x = x; this.y = y;
        }
    }
}