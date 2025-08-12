package BFS._4179;

import java.util.*;
import java.io.*;

public class Main {
    static char[][] board = new char[1002][1002];
    static int[][] dist1 = new int[1002][1002];
    static int[][] dist2 = new int[1002][1002];
    static int r, c;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Queue<Pair> Q1 = new ArrayDeque<>();
    static Queue<Pair> Q2 = new ArrayDeque<>();
    int ans = -1;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        for (int i = 0; i < r; i++) {
            Arrays.fill(dist1[i], -1);
            Arrays.fill(dist2[i], -1);
        }

        for (int i = 0; i < r; i++) {
            String s = br.readLine();
            for (int j = 0; j < c; j++) {
                board[i][j] = s.charAt(j);
                if (s.charAt(j) == 'F') {
                    Q1.add(new Pair(i, j));
                    dist1[i][j] = 0;
                }
                else if (s.charAt(j) == 'J') {
                    Q2.add(new Pair(i, j));
                    dist2[i][j] = 0;
                }
            }
        }

        while (!Q1.isEmpty()) {
            Pair cur = Q1.peek(); Q1.remove();
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                if (nx < 0 || nx >= r || ny < 0 || ny >= c) continue;
                if (board[nx][ny] == '#' || dist1[nx][ny] != -1) continue;
                Q1.add(new Pair(nx, ny));
                dist1[nx][ny] = dist1[cur.x][cur.y] + 1;
            }
        }

        while (!Q2.isEmpty()) {
            Pair cur = Q2.peek(); Q2.remove();
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                if (nx < 0 || nx >= r || ny < 0 || ny >= c) {
                    System.out.print(dist2[cur.x][cur.y] + 1);
                    return;
                }
                if (board[nx][ny] == '#' || dist2[nx][ny] != -1) continue;
                if (dist1[nx][ny] != -1 && dist1[nx][ny] <= dist2[cur.x][cur.y] + 1) continue;
                Q2.add(new Pair(nx, ny));
                dist2[nx][ny] = dist2[cur.x][cur.y] + 1;
            }
        }

        System.out.print("IMPOSSIBLE");
    }

    static class Pair {
        int x; int y;
        Pair(int x, int y) {
            this.x = x; this.y = y;
        }
    }

}
