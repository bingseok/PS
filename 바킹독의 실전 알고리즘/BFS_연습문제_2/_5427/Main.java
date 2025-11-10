package BFS_연습문제_2._5427;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static char[][] board = new char[1001][1001];
    static int[][] dist1 = new int[1001][1001]; // 불의 이동거리
    static int[][] dist2 = new int[1001][1001]; // 상근이의 이동거리
    static Queue<Pair> Q1 = new ArrayDeque<>();
    static Queue<Pair> Q2 = new ArrayDeque<>();
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int t, w, h;

    public static void main(String[] args) throws IOException {
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken()); // 너비
            h = Integer.parseInt(st.nextToken()); // 높이

            for (int i = 0; i < h; i++) {
                Arrays.fill(dist1[i], 0, w, -1);
                Arrays.fill(dist2[i], 0, w, -1);
            }

            for (int i = 0; i < h; i++) {
                String tmp = br.readLine();
                for (int j = 0; j < w; j++) {
                    board[i][j] = tmp.charAt(j);
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

            // 불의 BFS
            while (!Q1.isEmpty()) {
                Pair cur = Q1.peek(); Q1.remove();
                for (int dir = 0; dir < 4; dir++) {
                    int x = cur.x + dx[dir];
                    int y = cur.y + dy[dir];
                    if (x < 0 || x >= h || y < 0 || y >= w) continue;
                    if (board[x][y] == '#' || dist1[x][y] != -1) continue;
                    dist1[x][y] = dist1[cur.x][cur.y] + 1;
                    Q1.add(new Pair(x, y));
                }
            }

            boolean isEscape = false;
            // 상근이의 BFS
            while (!Q2.isEmpty() && !isEscape) {
                Pair cur = Q2.peek(); Q2.remove();
                for (int dir = 0; dir < 4; dir++) {
                    int x = cur.x + dx[dir];
                    int y = cur.y + dy[dir];
                    if (x < 0 || x >= h || y < 0 || y >= w) {
                        System.out.println(dist2[cur.x][cur.y] + 1);
                        isEscape = true;
                        break;
                    }
                    if (board[x][y] == '#' || dist2[x][y] != -1) continue;
                    if (dist1[x][y] != -1 && dist1[x][y] <= dist2[cur.x][cur.y] + 1) continue;
                    dist2[x][y] = dist2[cur.x][cur.y] + 1;
                    Q2.add(new Pair(x, y));
                }
            }

            if (!isEscape) System.out.println("IMPOSSIBLE");
            Q1.clear();
            Q2.clear();
        }
    }

    static class Pair {
        int x, y;
        Pair(int x, int y) {
            this.x = x; this.y = y;
        }
    }
}
