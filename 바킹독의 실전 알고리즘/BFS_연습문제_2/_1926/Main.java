package BFS_연습문제_2._1926;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] vis = new int[502][502];
    static int[][] board = new int[502][502];
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int n, m, cnt, ans;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // board 입력 받기
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // BFS 시작점 후보군 찾기
                if (board[i][j] == 1 && vis[i][j] == 0) {
                    // 후보군을 찾으면 cnt 1 증가
                    cnt++;
                    Queue<Pair> Q = new ArrayDeque<>();
                    Q.add(new Pair(i, j));
                    vis[i][j] = 1;
                    int area = 0;

                    while (!Q.isEmpty()) {
                        Pair cur = Q.peek(); Q.remove();
                        area++;
                        for (int dir = 0; dir < 4; dir++) {
                            int nx = cur.x + dx[dir];
                            int ny = cur.y + dy[dir];
                            if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                            if (board[nx][ny] == 0 || vis[nx][ny] != 0) continue;
                            Q.add(new Pair(nx, ny));
                            vis[nx][ny] = 1;
                        }
                    }
                    ans = Math.max(ans, area);
                }
            }
        }

        System.out.println(cnt);
        System.out.print(ans);
    }

    static class Pair {
        int x, y;
        Pair(int x, int y) {
            this.x = x; this.y = y;
        }
    }
}
