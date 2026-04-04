package BFS_연습문제._2206;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[][] board = new int[1002][1002];
    static int[][][] dist = new int[1002][1002][2];
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n, m;
    static Queue<Tuple> Q = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = s.charAt(j) - '0';
            }
        }

        dist[0][0][0] = 1;
        Q.add(new Tuple(0, 0, 0));
        while (!Q.isEmpty()) {
            Tuple cur = Q.peek(); Q.remove();
            if (cur.x == n-1 && cur.y == m-1) {
                System.out.print(dist[cur.x][cur.y][cur.isBreak]);
                return;
            }
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                if (OOB(nx, ny)) continue;
                if (board[nx][ny] == 1) {
                    if (cur.isBreak == 0) {
                        dist[nx][ny][1] = dist[cur.x][cur.y][0] + 1;
                        Q.add(new Tuple(nx, ny, 1));
                    }
                }
                if (board[nx][ny] == 0) {
                    if (dist[nx][ny][cur.isBreak] != 0) continue;
                    dist[nx][ny][cur.isBreak] = dist[cur.x][cur.y][cur.isBreak] + 1;
                    Q.add(new Tuple(nx, ny, cur.isBreak));
                }
            }
        }

        System.out.print(-1);
    }

    static boolean OOB(int nx, int ny) {
        return nx < 0 || nx >= n || ny < 0 || ny >= m;
    }
    static class Tuple {
        int x, y, isBreak;
        Tuple(int x, int y, int isBreak) {
            this.x = x; this.y = y; this.isBreak = isBreak;
        }
    }

}
