package BFS_연습문제._5427;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static char[][] board = new char[1002][1002];
    static int[][] dist1 = new int[1002][1002];
    static int[][] dist2 = new int[1002][1002];
    static Queue<Pair> Q1 = new ArrayDeque<>();
    static Queue<Pair> Q2 = new ArrayDeque<>();
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int t, w, h;

    public static void main(String[] args) throws IOException {
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            Q1.clear(); Q2.clear();
            for (int i = 0; i < h; i++) {
                Arrays.fill(dist1[i], 0, w, -1);
                Arrays.fill(dist2[i], 0, w, -1);
            }

            for (int i = 0; i < h; i++) {
                String s = br.readLine();
                for (int j = 0; j < w; j++) {
                    board[i][j] = s.charAt(j);
                    if (board[i][j] == '*') {
                        dist1[i][j] = 0;
                        Q1.add(new Pair(i, j));
                    }
                    if (board[i][j] == '@') {
                        dist2[i][j] = 0;
                        Q2.add(new Pair(i, j));
                    }
                }
            }

            bfs1();
            bfs2();
        }

        System.out.print(sb);
    }

    static void bfs1() {
        while (!Q1.isEmpty()) {
            Pair cur = Q1.peek(); Q1.remove();
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                if (OOB(nx, ny)) continue;
                if (board[nx][ny] == '#' || dist1[nx][ny] != -1) continue;
                dist1[nx][ny] = dist1[cur.x][cur.y] + 1;
                Q1.add(new Pair(nx, ny));
            }
        }
    }

    static void bfs2() {
        while (!Q2.isEmpty()) {
            Pair cur = Q2.peek(); Q2.remove();
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                if (OOB(nx, ny)) {
                    sb.append(dist2[cur.x][cur.y] + 1).append("\n");
                    return;
                }
                if (board[nx][ny] == '#' || dist2[nx][ny] != -1) continue;
                if (dist1[nx][ny] != -1 && dist1[nx][ny] <= dist2[cur.x][cur.y] + 1) continue;
                dist2[nx][ny] = dist2[cur.x][cur.y] + 1;
                Q2.add(new Pair(nx, ny));
            }
        }
        sb.append("IMPOSSIBLE\n");
    }

    static boolean OOB(int nx, int ny) {
        return nx < 0 || nx >= h || ny < 0 || ny >= w;
    }
    static class Pair {
        int x, y;
        Pair(int x, int y) {
            this.x = x; this.y = y;
        }
    }

}
