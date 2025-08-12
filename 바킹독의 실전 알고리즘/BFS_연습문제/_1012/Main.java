package BFS_연습문제._1012;

import java.util.*;
import java.io.*;

public class Main {
    static int[][] board = new int[52][52];
    static int[][] vis = new int[52][52];
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int t, n, m, k;
    static int num = 0;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken()); // 가로 길이
            n = Integer.parseInt(st.nextToken()); // 세로 길이
            k = Integer.parseInt(st.nextToken()); // 배추의 개수

            num = 0;
            for (int i = 0; i < n; i++) {
                Arrays.fill(board[i], 0, m, 0);
                Arrays.fill(vis[i], 0, m, 0);
            }

            while (k-- > 0) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                board[y][x] = 1;
            }

            Queue<Pair> Q = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (board[i][j] == 1 && vis[i][j] == 0) {
                        Q.add(new Pair(i, j));
                        vis[i][j] = 1;
                        num++;
                        while (!Q.isEmpty()) {
                            Pair cur = Q.peek(); Q.remove();
                            for (int dir = 0; dir < 4; dir++) {
                                int nx = cur.x + dx[dir];
                                int ny = cur.y + dy[dir];
                                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                                if (board[nx][ny] == 0 || vis[nx][ny] != 0) continue;
                                Q.add(new Pair(nx, ny));
                                vis[nx][ny] = 1;
                            }
                        }
                    }
                }
            }
            System.out.println(num);
        }
    }

    static class Pair {
        int x; int y;
        Pair(int x, int y) {
            this.x = x; this.y = y;
        }
    }
}