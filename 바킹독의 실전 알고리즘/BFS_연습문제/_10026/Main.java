package BFS_연습문제._10026;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static char[][] board = new char[102][102];
    static int[][] vis = new int[102][102];
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < n; j++)
                board[i][j] = tmp.charAt(j);
        }

        // 적록색약이 아닌 사람
        int num = 0;
        Queue<Pair> Q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (vis[i][j] == 0) {
                    Q.add(new Pair(i, j));
                    vis[i][j] = 1;
                    num++;
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
            }
        }

        System.out.print(num + " ");
        num = 0;

        for (int i = 0; i < n; i++) Arrays.fill(vis[i], 0);
        Q.clear();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (vis[i][j] == 0) {
                    Q.add(new Pair(i, j));
                    vis[i][j] = 1;
                    num++;
                    while (!Q.isEmpty()) {
                        Pair cur = Q.peek(); Q.remove();
                        for (int dir = 0; dir < 4; dir++) {
                            int nx = cur.x + dx[dir];
                            int ny = cur.y + dy[dir];
                            if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                            if (board[cur.x][cur.y] == 'B') {
                                if (board[nx][ny] != board[cur.x][cur.y]) continue;
                            }
                            else {
                                if (board[nx][ny] == 'B') continue;
                            }
                            if (vis[nx][ny] != 0) continue;
                            Q.add(new Pair(nx, ny));
                            vis[nx][ny] = 1;
                        }
                    }
                }
            }
        }

        System.out.print(num);

    }

    static class Pair {
        int x; int y;
        Pair(int x, int y) {
            this.x = x; this.y = y;
        }
    }
}
