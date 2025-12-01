package BFS_연습문제_2._2206;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] board = new int[1001][1001];
    static int[][][] dist = new int[1001][1001][2];
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Queue<Tuple> Q = new ArrayDeque<>();
    static int n, m;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // 1. board 입력 받기
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = input.charAt(j) - '0';
            }
        }

        // 2. dist 배열 초기화
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                dist[i][j][0] = dist[i][j][1] = 0;
        }

        dist[0][0][0] = 1;
        Q.add(new Tuple(0, 0, 0));

        System.out.print(bfs());
    }

    static int bfs() {
        while (!Q.isEmpty()) {
            var cur = Q.peek(); Q.remove();
            int x = cur.x; int y = cur.y; int isBreak = cur.isBreak;
            if (x == n-1 && y == m-1) {
                return dist[x][y][isBreak];
            }
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                if (OOB(nx, ny)) continue;
                if (board[nx][ny] == 0 && dist[nx][ny][isBreak] == 0) {
                    dist[nx][ny][isBreak] = dist[x][y][isBreak] + 1;
                    Q.add(new Tuple(nx, ny, isBreak));
                }
                if (isBreak == 0 && board[nx][ny] == 1 && dist[nx][ny][1] == 0) {
                    dist[nx][ny][1] = dist[x][y][0] + 1;
                    Q.add(new Tuple(nx, ny, 1));
                }
            }
        }

        return -1;
    }

    static boolean OOB(int x, int y) {
        return x < 0 || x >= n || y < 0 || y >= m;
    }
    static class Tuple {
        int x, y, isBreak; // isBreak가 0이면 벽을 부수지 않은 상태, 1이면 벽을 부순 상태
        Tuple(int x, int y,int  isBreak) {
            this.x = x; this.y = y; this.isBreak = isBreak;
        }
    }
}
