package BFS_연습문제._2206_1;

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] board = new int[1002][1002];
    static int[][][] dist = new int[1002][1002][2];
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n, m;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < m; j++)
                board[i][j] = tmp.charAt(j) - '0';
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                Arrays.fill(dist[i][j], -1);
        }

        Queue<Tuple> Q = new ArrayDeque<>();
        Q.add(new Tuple(0, 0, 0));
        dist[0][0][0] = 0;

        while (!Q.isEmpty()) {
            Tuple cur = Q.peek(); Q.remove();
            if (cur.x == n-1 && cur.y == m-1) {
                System.out.print(dist[cur.x][cur.y][cur.isBreak] + 1);
                return;
            }
            int isBreak = cur.isBreak;
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (isBreak == 1 && board[nx][ny] == 1) continue;
                if (board[nx][ny] == 0 && dist[nx][ny][isBreak] == -1) {
                    Q.add(new Tuple(nx, ny, isBreak));
                    dist[nx][ny][isBreak] = dist[cur.x][cur.y][isBreak] + 1;
                }
                if (board[nx][ny] == 1) {
                    if (isBreak == 0) {
                        Q.add(new Tuple(nx, ny, 1));
                        dist[nx][ny][1] = dist[cur.x][cur.y][0] + 1;
                    }
                }
            }
        }

        System.out.print(-1);
    }

    static class Tuple {
        int x; int y; int isBreak = 0;
        Tuple(int x, int y, int isBreak) {
            this.x = x; this.y = y; this.isBreak = isBreak;
        }
    }
}
