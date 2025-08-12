package BFS_연습문제._5427;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static char[][] board = new char[1002][1002];
    static int[][] dist1 = new int[1002][1002];
    static int[][] dist2 = new int[1002][1002];
    static Queue<Pair> Q1 = new ArrayDeque<>();
    static Queue<Pair> Q2 = new ArrayDeque<>();
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int t, w, h;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            Q1.clear(); Q2.clear();
            for (int i = 0; i < h; i++) {
                Arrays.fill(dist1[i], 0, w, -1);
                Arrays.fill(dist2[i], 0, w, -1);
            }

            for (int i = 0; i < h; i++) {
                String tmp = br.readLine();
                for (int j = 0; j < w; j++) {
                    board[i][j] = tmp.charAt(j);
                    if (board[i][j] == '*') {
                        Q1.add(new Pair(i, j));
                        dist1[i][j] = 0;
                    }
                    else if (board[i][j] == '@') {
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
                    if (nx < 0 || nx >= h || ny < 0 || ny >= w) continue;
                    if (board[nx][ny] == '#' || dist1[nx][ny] != -1) continue;
                    Q1.add(new Pair(nx, ny));
                    dist1[nx][ny] = dist1[cur.x][cur.y] + 1;
                }
            }

            boolean isSuccess = false;

            while (!Q2.isEmpty()) {
                if (isSuccess) break;
                Pair cur = Q2.peek(); Q2.remove();
                for (int dir = 0; dir < 4; dir++) {
                    int nx = cur.x + dx[dir];
                    int ny = cur.y + dy[dir];
                    if (nx < 0 || nx >= h || ny < 0 || ny >= w) {
                        isSuccess = true;
                        sb.append(dist2[cur.x][cur.y] + 1);
                        sb.append("\n");
                        break;
                    }
                    if (board[nx][ny] == '#' || dist2[nx][ny] != -1) continue;
                    if (dist1[nx][ny] != -1 && dist1[nx][ny] <= dist2[cur.x][cur.y] + 1) continue;
                    Q2.add(new Pair(nx, ny));
                    dist2[nx][ny] = dist2[cur.x][cur.y] + 1;
                }
            }
            if (!isSuccess) sb.append("IMPOSSIBLE\n");
        }
        System.out.print(sb);
    }

    static class Pair {
        int x; int y;
        Pair(int x, int y) {
            this.x = x; this.y = y;
        }
    }
}
