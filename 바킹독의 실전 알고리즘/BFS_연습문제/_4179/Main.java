package BFS_연습문제._4179;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int r, c;
    static char[][] board = new char[1002][1002];
    static Queue<Pair> Q1 = new ArrayDeque<>();
    static Queue<Pair> Q2 = new ArrayDeque<>();
    static int[][] dist1 = new int[1002][1002];
    static int[][] dist2 = new int[1002][1002];
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        for (int i = 0; i < r; i++) {
            Arrays.fill(dist1[i], 0, c, -1);
            Arrays.fill(dist2[i], 0, c, -1);
        }

        for (int i = 0; i < r; i++) {
            String s = br.readLine();
            for (int j = 0; j < c; j++) {
                board[i][j] = s.charAt(j);
                if (board[i][j] == 'F') {
                    dist1[i][j] = 0;
                    Q1.add(new Pair(i, j));
                }
                if (board[i][j] == 'J') {
                    dist2[i][j] = 0;
                    Q2.add(new Pair(i, j));
                }
            }
        }

        bfs1();
        bfs2();
    }

    static void bfs1() {
        while (!Q1.isEmpty()) {
            Pair cur = Q1.peek(); Q1.remove();
            for (int dir = 0; dir < 4; dir++) {
                int x = cur.x + dx[dir];
                int y = cur.y + dy[dir];
                if (OOB(x, y)) continue;
                if (board[x][y] == '#' || dist1[x][y] != -1) continue;
                dist1[x][y] = dist1[cur.x][cur.y] + 1;
                Q1.add(new Pair(x, y));
            }
        }
    }

    static void bfs2() {
        while (!Q2.isEmpty()) {
            Pair cur = Q2.peek(); Q2.remove();
            for (int dir = 0; dir < 4; dir++) {
                int x = cur.x + dx[dir];
                int y = cur.y + dy[dir];
                if (OOB(x, y)) {
                    System.out.print(dist2[cur.x][cur.y] + 1);
                    return;
                }
                if (board[x][y] == '#' || dist2[x][y] != -1) continue;
                if (dist1[x][y] != -1 && dist1[x][y] <= dist2[cur.x][cur.y] + 1) continue;
                dist2[x][y] = dist2[cur.x][cur.y] + 1;
                Q2.add(new Pair(x, y));
            }
        }

        System.out.print("IMPOSSIBLE");
    }
    static boolean OOB(int x, int y) {
        return x < 0 || x >= r || y < 0 || y >= c;
    }
    static class Pair {
        int x, y;
        Pair(int x, int y) {
            this.x = x; this.y = y;
        }
    }
}
