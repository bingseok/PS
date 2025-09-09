package _2146;

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n;
    static int[][] board = new int[102][102];
    static int[][] dist = new int[102][102];
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Queue<Pair> Q = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n ; i++) {
            st = new StringTokenizer(br.readLine());
            Arrays.fill(dist[i], -1);
            for (int j = 0; j < n; j++)
                board[i][j] = Integer.parseInt(st.nextToken());
        }

        int city = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1 && dist[i][j] == -1) {
                    board[i][j] = city;
                    Q = new ArrayDeque<>();
                    Q.add(new Pair(i, j));
                    dist[i][j] = 0;
                    while (!Q.isEmpty()) {
                        Pair cur = Q.peek(); Q.remove();
                        for (int dir = 0; dir < 4; dir++) {
                            int nx = cur.x + dx[dir];
                            int ny = cur.y + dy[dir];
                            if (OOB(nx, ny)) continue;
                            if (board[nx][ny] == 0 || dist[nx][ny] != -1) continue;
                            Q.add(new Pair(nx, ny));
                            dist[nx][ny] = 0;
                            board[nx][ny] = city;
                        }
                    }
                    city++;
                }
            }
        }

        Q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) Arrays.fill(dist[i], -1);

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] != 0) {
                    for (int k = 0; k < n; k++) Arrays.fill(dist[k], -1);
                    Q.clear();
                    int ans = bfs(i, j);
                    if (ans != -1)
                        answer = Math.min(answer, ans);
                }
            }
        }
        System.out.print(answer);
    }

    static int bfs(int i, int j) {
        int city = board[i][j];
        Q.add(new Pair(i, j));
        dist[i][j] = 0;
        while (!Q.isEmpty()) {
            Pair cur= Q.peek(); Q.remove();
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                if (OOB(nx, ny)) continue;
                if (dist[nx][ny] != -1) continue;
                if (board[nx][ny] != 0 && board[nx][ny] == city) continue;
                if (board[nx][ny] != 0 && board[nx][ny] != city) {
                    return dist[cur.x][cur.y];
                }
                Q.add(new Pair(nx, ny));
                dist[nx][ny] = dist[cur.x][cur.y] + 1;
            }
        }
        return -1;
    }

    static boolean check(int i, int j) {
        for (int dir = 0; dir < 4; dir++) {
            int nx = i + dx[dir];
            int ny = j + dy[dir];
            if (OOB(nx, ny)) continue;
            if (board[nx][ny] == 0) return true;
        }
        return false;
    }

    static boolean OOB(int nx, int ny) {
        return nx < 0 || nx >= n || ny < 0 || ny >= n;
    }

    static class Pair {
        int x, y;
        Pair(int x, int y) {
            this.x = x; this.y = y;
        }
    }
}
