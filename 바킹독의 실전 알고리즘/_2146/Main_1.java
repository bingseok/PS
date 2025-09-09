package _2146;

import java.io.*;
import java.util.*;

public class Main_1 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] board = new int[102][102];
    static int[][] vis = new int[102][102];
    static int[][] dist = new int[102][102];
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Queue<Pair> Q = new ArrayDeque<>();
    static int n, ans = Integer.MAX_VALUE, city = 1;

    public static void main(String[] args) throws IOException {
        // 입력 받기
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            Arrays.fill(dist[i], 0, n, -1);
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 도시 구분을 위한 인덱싱
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1 && vis[i][j] == 0) {
                    Q.add(new Pair(i, j));
                    vis[i][j] = 1;
                    board[i][j] = city;
                    while (!Q.isEmpty()) {
                        Pair cur = Q.peek(); Q.remove();
                        for (int dir = 0; dir < 4; dir++) {
                            int nx = cur.x + dx[dir];
                            int ny = cur.y + dy[dir];
                            if (OOB(nx, ny)) continue;
                            if (board[nx][ny] == 0 || vis[nx][ny] != 0) continue;
                            board[nx][ny] = city;
                            Q.add(new Pair(nx, ny));
                            vis[nx][ny] = 1;
                        }
                    }
                    city++;
                    Q.clear();
                    for (int k = 0; k < n; k++) Arrays.fill(vis[k], 0, n, 0);
                }
            }
        }


        // 섬인 지역에서 BFS 진행, 다른 도시를 만나면 break를 통해 BFS를 중단하여 최적화
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] != 0) {
                    Q.add(new Pair(i, j));
                    dist[i][j] = 0;
                    boolean escape = false;
                    while (!Q.isEmpty() && !escape) {
                        Pair cur = Q.peek(); Q.remove();
                        for (int dir = 0; dir < 4; dir++) {
                            int nx = cur.x + dx[dir];
                            int ny = cur.y + dy[dir];
                            if (OOB(nx, ny)) continue;
                            if (dist[nx][ny] != -1 || board[nx][ny] == board[i][j]) continue;
                            if (board[nx][ny] != 0 && board[nx][ny] != board[i][j]) {
                                ans = Math.min(ans, dist[cur.x][cur.y]);
                                Q.clear();
                                escape = true;
                                break;
                            }
                            Q.add(new Pair(nx, ny));
                            dist[nx][ny] = dist[cur.x][cur.y] + 1;
                        }
                    }
                    for(int k = 0; k < n; k++) Arrays.fill(dist[k], 0, n, -1);
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
