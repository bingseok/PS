package BFS_연습문제_2._2178;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] board = new int[102][102];
    static int[][] dist = new int[102][102];
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n, m;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = tmp.charAt(j) - '0';
            }
        }

        for (int i = 0; i < n; i++) Arrays.fill(dist[i], 0, m, -1);

        Queue<Pair> Q = new ArrayDeque<>();
        Q.add(new Pair(0, 0));
        dist[0][0] = 0;

        while (!Q.isEmpty() && dist[n-1][m-1] == -1) {
            Pair cur = Q.peek(); Q.remove();
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                if (OOB(nx, ny)) continue;
                if (board[nx][ny] == 0 || dist[nx][ny] != -1) continue;
                Q.add(new Pair(nx, ny));
                dist[nx][ny] = dist[cur.x][cur.y] + 1;
            }
        }

        System.out.println(dist[n-1][m-1] + 1);
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
