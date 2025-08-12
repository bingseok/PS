package BFS_연습문제._7562;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] dist = new int[302][302];
    static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};
    static int n, l;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            l = Integer.parseInt(br.readLine());
            for (int j = 0; j < l; j++) Arrays.fill(dist[j], 0, l, -1);

            StringTokenizer st = new StringTokenizer(br.readLine());
            int curX = Integer.parseInt(st.nextToken());
            int curY = Integer.parseInt(st.nextToken());
            Queue<Pair> Q = new ArrayDeque<>();
            Q.add(new Pair(curX, curY));
            dist[curX][curY] = 0;

            st = new StringTokenizer(br.readLine());
            int distX = Integer.parseInt(st.nextToken());
            int distY = Integer.parseInt(st.nextToken());
            while (dist[distX][distY] == -1) {
                Pair cur = Q.peek(); Q.remove();
                for (int dir = 0; dir < 8; dir++) {
                    int nx = cur.x + dx[dir];
                    int ny = cur.y + dy[dir];
                    if (nx < 0 || nx >= l || ny < 0 || ny >= l) continue;
                    if (dist[nx][ny] != -1) continue;
                    Q.add(new Pair(nx, ny));
                    dist[nx][ny] = dist[cur.x][cur.y] + 1;
                }
            }
            System.out.println(dist[distX][distY]);
        }
    }

    static class Pair {
        int x; int y;
        Pair(int x, int y) {
            this.x = x; this.y = y;
        }
    }
}
