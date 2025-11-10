package BFS_연습문제_2._7562;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] dist = new int[301][301];
    static int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] dy = {2, 1, -1, -2, -2, -1, 1, 2};
    static int t, l;

    public static void main(String[] args) throws IOException {
        t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            l = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            Queue<Pair> Q = new ArrayDeque<>();
            for (int i = 0; i < l; i++) Arrays.fill(dist[i], 0, l, -1);
            int curX = Integer.parseInt(st.nextToken());
            int curY = Integer.parseInt(st.nextToken());
            dist[curX][curY] = 0;
            Q.add(new Pair(curX, curY));

            st = new StringTokenizer(br.readLine());
            int distX = Integer.parseInt(st.nextToken());
            int distY = Integer.parseInt(st.nextToken());

            while (dist[distX][distY] == -1) {
                Pair cur = Q.peek(); Q.remove();
                for (int dir = 0; dir < 8; dir++) {
                    int x = cur.x + dx[dir];
                    int y = cur.y + dy[dir];
                    if (x < 0 || x >= l || y < 0 || y >= l) continue;
                    if (dist[x][y] != -1) continue;
                    dist[x][y] = dist[cur.x][cur.y] + 1;
                    Q.add(new Pair(x, y));
                }
            }
            System.out.println(dist[distX][distY]);
        }
    }

    static class Pair {
        int x, y;
        Pair(int x, int y) {
            this.x = x; this.y = y;
        }
    }
}
