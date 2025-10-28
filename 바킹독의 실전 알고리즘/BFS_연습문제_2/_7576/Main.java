package BFS_연습문제_2._7576;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] board = new int[1002][1002];
    static int[][] dist = new int[1002][1002];
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int m, n;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        Queue<Pair> Q = new ArrayDeque<>();
        // for (int i = 0; i < n; i++) Arrays.fill(dist[i], 0, m, -1);

        // board 입력 받기
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 1) {
                    Q.add(new Pair(i, j));
                }
                if (board[i][j] == 0) dist[i][j] = -1;
            }
        }

        // BFS
        while (!Q.isEmpty()) {
            Pair cur = Q.peek(); Q.remove();
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                if (OOB(nx, ny)) continue;
                if (board[nx][ny] == -1 || dist[nx][ny] != -1) continue;
                Q.add(new Pair(nx, ny));
                dist[nx][ny] = dist[cur.x][cur.y] + 1;
            }
        }

        // 결과 확인
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dist[i][j] == -1) {
                    System.out.print(-1);
                    return;
                }
                ans = Math.max(ans, dist[i][j]);
            }
        }

        System.out.print(ans);
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
