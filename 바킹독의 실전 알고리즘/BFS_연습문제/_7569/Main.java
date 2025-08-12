package BFS_연습문제._7569;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][][] board = new int[102][102][102];
    static int[][][] dist = new int[102][102][102];
    static int[] dx = {1, 0, -1, 0, 0, 0};
    static int[] dy = {0, 1, 0, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static Queue<Tuple> Q = new ArrayDeque<>();
    static int m, n, h;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken()); // 가로 칸
        n = Integer.parseInt(st.nextToken()); // 세로 칸
        h = Integer.parseInt(st.nextToken()); // 높이


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

        System.out.print(res());
    }

    static int res() {
        int cnt = 0;
        bfs();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (dist[i][j][k] == -1) {
                        return -1;
                    }
                    cnt = Math.max(cnt, dist[i][j][k]);
                }
            }
        }

        return cnt;
    }

    static void bfs() {
        while (!Q.isEmpty()) {
            Tuple cur = Q.peek(); Q.remove();
            for (int dir = 0; dir < 6; dir++) {
                int nz = cur.z + dz[dir];
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                if (OOB(nx, ny, nz)) continue;
                if (board[nz][nx][ny] == -1 || dist[nz][nx][ny] != -1) continue;
                Q.add(new Tuple(nz, nx, ny));
                dist[nz][nx][ny] = dist[cur.z][cur.x][cur.y] + 1;
            }
        }
    }

    static boolean OOB(int nx, int ny, int nz) {
        if (nx < 0 || nx >= n || ny < 0 || ny >= m || nz < 0 || nz >= h) return true;
        else return false;

    }

    static class Tuple {
        int z; int x; int y;
        Tuple(int z, int x, int y) {
            this.z = z; this.x = x; this.y = y;
        }
    }
}
