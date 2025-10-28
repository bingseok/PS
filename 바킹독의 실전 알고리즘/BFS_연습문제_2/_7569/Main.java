package BFS_연습문제_2._7569;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][][] board = new int[102][102][102];
    static int[][][] dist = new int[102][102][102];
    static int[] dx = {1, 0, -1, 0, 0, 0};
    static int[] dy = {0, 1, 0, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int m, n, h;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken()); // 가로
        n = Integer.parseInt(st.nextToken()); // 세로
        h = Integer.parseInt(st.nextToken()); // 높이

        Queue<Tuple> Q = new ArrayDeque<>();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    board[i][j][k] = Integer.parseInt(st.nextToken());
                    if (board[i][j][k] == 1) {
                        Q.add(new Tuple(i, j, k));
                    }
                    else if (board[i][j][k] == 0) dist[i][j][k] = -1;
                }
            }
        }

        while (!Q.isEmpty()) {
            Tuple cur = Q.peek(); Q.remove();
            for (int dir = 0; dir < 6; dir++) {
                int z = cur.z + dz[dir];
                int x = cur.x + dx[dir];
                int y = cur.y + dy[dir];
                if (x < 0 || x >= n || y < 0 || y >= m || z < 0 || z >= h) continue;
                if (board[z][x][y] == -1 || dist[z][x][y] != -1) continue;
                Q.add(new Tuple(z, x, y));
                dist[z][x][y] = dist[cur.z][cur.x][cur.y] + 1;
            }
        }

        int ans = Integer.MIN_VALUE;
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

    static class Tuple {
        int z, x, y;
        Tuple(int z, int x, int y) {
            this.z = z; this.x = x; this.y = y;
        }
    }
}
