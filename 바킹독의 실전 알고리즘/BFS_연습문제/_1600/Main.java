package BFS_연습문제._1600;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] board = new int[202][202];
    static int[][][] dist = new int[202][202][31];
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[] hdx = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] hdy = {2, 1, -1, -2, -2, -1, 1, 2};
    static Queue<Tuple> Q = new ArrayDeque<>();
    static int k, w, h;

    public static void main(String[] args) throws IOException {
        k = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        for (int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < w; j++)
                board[i][j] = Integer.parseInt(st.nextToken());
        }

        System.out.print(bfs());
    }

    static int bfs() {
        Q.add(new Tuple(0, 0, 0));
        dist[0][0][0] = 1;

        int ans = Integer.MAX_VALUE;

        while (!Q.isEmpty()) {
            Tuple cur = Q.peek(); Q.remove();
            int cnt = cur.cnt;
            if (cnt < k) {
                for (int dir = 0; dir < 8; dir++) {
                    int x = cur.x + hdx[dir];
                    int y = cur.y + hdy[dir];
                    if (OOB(x, y)) continue;
                    if (board[x][y] == 1 || dist[x][y][cnt+1] != 0) continue;
                    Q.add(new Tuple(x, y, cnt + 1));
                    dist[x][y][cnt+1] = dist[cur.x][cur.y][cnt] + 1;
                }
            }
            for (int dir = 0; dir < 4 ; dir++) {
                int x = cur.x + dx[dir];
                int y = cur.y + dy[dir];
                if (OOB(x, y)) continue;
                if (board[x][y] == 1 || dist[x][y][cnt] != 0) continue;
                Q.add(new Tuple(x, y, cnt));
                dist[x][y][cur.cnt] = dist[cur.x][cur.y][cur.cnt] + 1;
            }
        }

        for (int i = 0; i <= k; i++) {
            int tmp = dist[h-1][w-1][i];
            if (tmp == 0) continue;
            ans = Math.min(tmp, ans);
        }

        if (ans == Integer.MAX_VALUE) return -1;
        else return ans-1;
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
