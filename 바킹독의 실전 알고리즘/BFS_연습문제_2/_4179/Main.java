package BFS_연습문제_2._4179;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static char[][] board = new char[1002][1002];
    static int[][] dist1 = new int[1002][1002]; // 불의 이동거리
    static int[][] dist2 = new int[1002][1002]; // 지훈이의 이동거리
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int r, c;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        Queue<Pair> Q1 = new ArrayDeque<>(); // 불의 큐
        Queue<Pair> Q2 = new ArrayDeque<>(); // 지훈이의 큐

        // 이동 거리 -1로 초기화
        for (int i = 0; i < r; i++) {
            Arrays.fill(dist1[i], 0, c, -1);
            Arrays.fill(dist2[i], 0, c, -1);
        }

        // 입력 받기
        for (int i = 0; i < r; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < c; j++) {
                board[i][j] = tmp.charAt(j);
                if (board[i][j] == 'F') {
                    Q1.add(new Pair(i, j));
                    dist1[i][j] = 0;
                }
                else if (board[i][j] == 'J') {
                    Q2.add(new Pair(i, j));
                    dist2[i][j] = 0;
                }
            }
        }

        // 불의 BFS
        while (!Q1.isEmpty()) {
            Pair cur = Q1.peek(); Q1.remove();
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                if (OOB(nx, ny)) continue;
                if (board[nx][ny] == '#' || dist1[nx][ny] != -1) continue;
                Q1.add(new Pair(nx, ny));
                dist1[nx][ny] = dist1[cur.x][cur.y] + 1;
            }
        }

        // 지훈이의 BFS
        while (!Q2.isEmpty()) {
            Pair cur = Q2.peek(); Q2.remove();
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                if (OOB(nx, ny)) {
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

    static boolean OOB(int nx, int ny) {
        return nx < 0 || nx >= r || ny < 0 || ny >= c;
    }
    static class Pair {
        int x, y;
        Pair(int x, int y) {
            this.x = x; this.y = y;
        }
    }
}
