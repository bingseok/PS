package BFS_연습문제._7569;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[][][] board = new int[102][102][102];
    static int[][][] dist = new int[102][102][102];
    static int[] dx = {1, -1, 0, 0, 0, 0};  // 높이
    static int[] dy = {0, 0, 1, 0, -1, 0}; // 열
    static int[] dz = {0, 0, 0, 1, 0, -1}; // 행
    static Queue<Tuple> Q = new ArrayDeque<>();
    static int m, n, h;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    board[i][j][k] = Integer.parseInt(st.nextToken());
                    if (board[i][j][k] == 1) Q.add(new Tuple(i, j, k));
                    if (board[i][j][k] == 0) dist[i][j][k] = -1;
                }
            }
        }

        bfs();

        int ans = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (dist[i][j][k] == -1) {
                        System.out.print(-1);
                        return;
                    }
                    ans = Math.max(ans, dist[i][j][k]);
                }
            }
        }
        System.out.print(ans);
    }

    static void bfs() {
        while (!Q.isEmpty()) {
            Tuple cur = Q.peek(); Q.remove();
            for (int dir = 0; dir < 6; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                int nz = cur.z + dz[dir];
                if (OOB(nx, ny, nz)) continue;
                if (board[nx][ny][nz] != 0 || dist[nx][ny][nz] != -1) continue;
                dist[nx][ny][nz] = dist[cur.x][cur.y][cur.z] + 1;
                Q.add(new Tuple(nx, ny, nz));
            }
        }
    }

    static boolean OOB(int nx, int ny, int nz) {
        return nx < 0 || nx >= h || ny < 0 || ny >= n || nz < 0 || nz >= m;
    }
    static class Tuple {
        int x, y, z;
        Tuple(int x, int y, int z) {
            this.x = x; this.y = y; this.z = z;
        }
    }
}
