package BFS._1926;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] board = new int[502][502];
    static int[][] vis = new int[502][502];
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Queue<Pair> Q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        int n, m;
        int cnt = 0, mx = 0;

        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]); m = Integer.parseInt(s[1]);
        for (int i = 0; i < n; i++) {
            String tmp = br.readLine();
            StringTokenizer st = new StringTokenizer(tmp);
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 1 && vis[i][j] == 0) {
                    int area = 0; cnt++;
                    Q.add(new Pair(i, j));
                    vis[i][j] = 1;
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
                    mx = Math.max(mx, area);
                }
            }
        }

        System.out.println(cnt);
        System.out.print(mx);
    }

    static class Pair {
        int x; int y;
        public Pair(int x, int y) {
            this.x = x; this.y = y;
        }
    }
}
