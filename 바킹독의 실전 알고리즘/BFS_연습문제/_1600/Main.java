package BFS_연습문제._1600;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[][] board = new int[202][202];
    static int[][][] dist = new int[202][202][32];
    static Queue<Tuple> Q = new ArrayDeque<>();
    static int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] dy = {2, 1, -1, -2, -2, -1, 1, 2};
    static int[] fx ={1, 0, -1, 0};
    static int[] fy = {0, 1, 0, -1};
    static int k, w, h;

    public static void main(String[] args) throws IOException {
        k = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        for (int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < w; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dist[0][0][0] = 1;
        Q.add(new Tuple(0, 0, 0));

        while (!Q.isEmpty()) {
            var cur = Q.peek(); Q.remove();
            if (cur.x == h-1 && cur.y == w-1) {
                System.out.print(dist[cur.x][cur.y][cur.cnt] - 1);
                return;
            }
            if (cur.cnt < k) {
                int cnt = cur.cnt + 1;
                for (int dir = 0; dir < 8; dir++) {
                    int nx = cur.x + dx[dir];
                    int ny = cur.y + dy[dir];
                    if (OOB(nx, ny)) continue;
                    if (board[nx][ny] != 0 || dist[nx][ny][cnt] != 0) continue;
                    dist[nx][ny][cnt] = dist[cur.x][cur.y][cur.cnt] + 1;
                    Q.add(new Tuple(nx, ny, cnt));
                }
            }
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + fx[dir];
                int ny = cur.y + fy[dir];
                if (OOB(nx, ny)) continue;
                if (board[nx][ny] != 0 || dist[nx][ny][cur.cnt] != 0) continue;
                dist[nx][ny][cur.cnt] = dist[cur.x][cur.y][cur.cnt] + 1;
                Q.add(new Tuple(nx, ny, cur.cnt));
            }
        }

        System.out.print(-1);
    }

    static boolean OOB(int x, int y) {
        return x < 0 || x >= h || y < 0 || y >= w;
    }

    static class Tuple {
        int x, y, cnt;
        Tuple(int x, int y, int cnt) {
            this.x = x; this.y = y; this.cnt = cnt;
        }
    }
}
