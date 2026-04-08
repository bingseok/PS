package BFS_연습문제._2146_2;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    final static int MX = 102;
    static int[][] board = new int[MX][MX];
    static int[][] vis = new int[MX][MX];
    static int[][] dist = new int[MX][MX];
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Queue<Pair> Q = new ArrayDeque<>();
    static int n;
    static int ans = Integer.MAX_VALUE;


    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        island();
        System.out.print(bfs());

    }

    static int bfs() {
        for (int i = 0; i < n; i++) Arrays.fill(dist[i], 0, n, -1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] != 0) {
                    dist[i][j] = 0;
                    Q.add(new Pair(i, j));
                }
            }
        }

        while (!Q.isEmpty()) {
            Pair cur = Q.peek(); Q.remove();
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                if (OOB(nx, ny) || board[nx][ny] == board[cur.x][cur.y]) continue; // OOB이거나 같은 섬인 경우
                if (board[nx][ny] != 0) { // 인접한 곳이 다른 섬인 경우
                    ans = Math.min(ans, dist[nx][ny] + dist[cur.x][cur.y]);
                }
                else { // 바다인 경우
                    board[nx][ny] = board[cur.x][cur.y];
                    dist[nx][ny] = dist[cur.x][cur.y] + 1;
                    Q.add(new Pair(nx, ny));
                }
            }
        }

        return ans;
    }
    static void island() {
        int cnt = 1 ;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (vis[i][j] != 0 || board[i][j] == 0) continue;
                vis[i][j] = 1;
                Q.add(new Pair(i, j));
                while (!Q.isEmpty()) {
                    Pair cur = Q.peek(); Q.remove();
                    board[cur.x][cur.y] = cnt;
                    for (int dir = 0; dir < 4; dir++) {
                        int nx = cur.x + dx[dir];
                        int ny = cur.y + dy[dir];
                        if (OOB(nx, ny) || vis[nx][ny] != 0 || board[nx][ny] == 0) continue;
                        vis[nx][ny] = 1;
                        Q.add(new Pair(nx, ny));
                    }
                }
                cnt++;
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
