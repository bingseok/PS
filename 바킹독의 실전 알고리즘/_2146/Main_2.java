package _2146;

import java.util.*;
import java.io.*;

public class Main_2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] board = new int[102][102];
    static int[][] vis = new int[102][102];
    static int[][] dist = new int[102][102];
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Queue<Pair> Q = new ArrayDeque<>();
    static int n, city = 1, ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1 && vis[i][j] == 0) {
                    board[i][j] = city;
                    Q.add(new Pair(i, j));
                    vis[i][j] = 1;
                    while (!Q.isEmpty()) {
                        Pair cur = Q.peek(); Q.remove();
                        for (int dir = 0; dir < 4; dir++) {
                            int nx = cur.x + dx[dir];
                            int ny = cur.y + dy[dir];
                            if (OOB(nx, ny)) continue;
                            if (board[nx][ny] == 0 || vis[nx][ny] != 0) continue;
                            Q.add(new Pair(nx, ny));
                            vis[nx][ny] = 1;
                            board[nx][ny] = city;
                        }
                    }
                    city++;
                }
            }
        }

        for (int i = 0; i < n; i++) Arrays.fill(dist[i], 0, n, -1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] != 0) {
                    dist[i][j] = 0;
                    Q.add(new Pair(i, j));
                }
            }
        }

        while (!Q.isEmpty()) {
            Pair cur = Q.peek(); Q.remove();
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                if (OOB(nx, ny)) continue;
                if (board[nx][ny] == board[cur.x][cur.y]) continue; // 현재 섬과 같은 경우
                if (board[nx][ny] != 0) { // 다른 섬을 만난 경우 두 점이 섬으로부터 떨어진 거리를 합함
                    ans = Math.min(ans, dist[nx][ny] + dist[cur.x][cur.y]);
                }
                else { // 바다인 경우, 해당 바다를 섬으로 확장 후 큐에 추가
                    board[nx][ny] = board[cur.x][cur.y];
                    Q.add(new Pair(nx, ny));
                    dist[nx][ny] = dist[cur.x][cur.y] + 1;
                }
            }
        }

        System.out.print(ans);
    }

    static boolean OOB(int nx, int ny) {
        return nx < 0 || nx >= n || ny < 0 || ny >= n;
    }
    static class Pair {
        int x, y;
        Pair(int x, int y) {
            this.x = x; this.y = y;
        }
    }
}
