package BFS_연습문제._2206_2;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] board = new int[1002][1002];
    static int[][][] dist = new int[1002][1002][2];
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n, m;
    static Queue<Tuple> Q = new ArrayDeque<>();

    static int BFS() {
        Q.add(new Tuple(0, 0, 0));
        dist[0][0][0] = 1;

        while (!Q.isEmpty()) {
            Tuple cur = Q.peek(); Q.remove();
            if (cur.x == n-1 && cur.y == m-1)
                return dist[cur.x][cur.y][cur.isBreak];
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                if (OOB(nx, ny)) continue;
                if (board[nx][ny] == 0 && dist[nx][ny][cur.isBreak] == 0) {
                    Q.add(new Tuple(nx, ny, cur.isBreak));
                    dist[nx][ny][cur.isBreak] = dist[cur.x][cur.y][cur.isBreak] + 1;
                }
                if (board[nx][ny] == 1 && cur.isBreak == 0 && dist[nx][ny][1] == 0) {
                    Q.add(new Tuple(nx, ny, 1));
                    dist[nx][ny][1] = dist[cur.x][cur.y][cur.isBreak] + 1;
                }
            }
        }

        return -1;
    }

    static boolean OOB(int nx, int ny) {
        return nx < 0 || nx >= n || ny < 0 || ny >= m;
    }
    public static void main(String args[]) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < m; j++)
                board[i][j] = tmp.charAt(j) - '0';
        }

        System.out.print(BFS());
    }

    static class Tuple {
        int x, y, isBreak;
        Tuple(int x, int y, int isBreak) {
            this.x = x; this.y = y; this.isBreak = isBreak;
        }
    }
}
