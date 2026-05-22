package _백트래킹_연습문제._1941;

import java.util.*;
import java.io.*;

public class Main {
    static char[][] board = new char[5][5];
    static boolean[] selected = new boolean[25];
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++)
            board[i] = br.readLine().toCharArray();

        func(0, 0, 0);
        System.out.print(ans);
    }

    static void func(int idx, int count, int sCount) {
        if (count == 7) {
            if (sCount >= 4 && isConnected())
                ans++;
            return;
        }

        if (idx >= 25) return;

        // idx번째 학생 선택
        selected[idx] = true;
        int x = idx / 5;
        int y = idx % 5;
        func(idx+1, count+1, sCount + (board[x][y] == 'S' ? 1 : 0));
        selected[idx] = false;

        // idx번째 학생 선택 안함
        func(idx+1, count, sCount);
    }

    static boolean isConnected() {
        Queue<Integer> Q = new ArrayDeque<>();
        boolean[] visited = new boolean[25];

        int start = -1;
        for (int i = 0; i < 25; i++) {
            if (selected[i]) {
                start = i;
                break;
            }
        }

        Q.offer(start);
        visited[start] = true;

        int connectCount = 0;

        while (!Q.isEmpty()) {
            int cur = Q.poll();
            connectCount++;
            int x = cur / 5;
            int y = cur % 5;
            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                if (OOB(nx, ny)) continue;
                int next = 5 * nx + ny;
                if (!selected[next]) continue;
                if (visited[next]) continue;
                Q.offer(next);
                visited[next] = true;
            }
        }

        return connectCount == 7;
    }

    static boolean OOB(int x, int y) {
        return x < 0 || x >= 5 || y < 0 || y >= 5;
    }
}