package BFS_연습문제._7562;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[][] dist = new int[302][302];
    static Queue<Pair> Q = new ArrayDeque<>();
    static int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] dy = {2, 1, -1, -2, -2, -1, 1, 2};
    static int t, l;

    public static void main(String[] args) throws IOException {
        t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            l = Integer.parseInt(br.readLine());

            Q.clear();
            for (int i = 0; i < l; i++) Arrays.fill(dist[i], 0, l, -1);

            st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());

            dist[startX][startY] = 0;
            Q.add(new Pair(startX, startY));
            while (dist[endX][endY] == -1) {
                Pair cur = Q.peek(); Q.remove();
                for (int dir = 0; dir < 8; dir++) {
                    int nx = cur.x + dx[dir];
                    int ny = cur.y + dy[dir];
                    if (OOB(nx, ny)) continue;
                    if (dist[nx][ny] != -1) continue;
                    dist[nx][ny] = dist[cur.x][cur.y] + 1;
                    Q.add(new Pair(nx, ny));
                }
            }

            sb.append(dist[endX][endY]).append("\n");
        }

        System.out.print(sb);
    }

    static boolean OOB(int nx, int ny) {
        return nx < 0 || nx >= l || ny < 0 || ny >= l;
    }
    static class Pair {
        int x, y;
        Pair(int x, int y) {
            this.x = x; this.y = y;
        }
    }
}
