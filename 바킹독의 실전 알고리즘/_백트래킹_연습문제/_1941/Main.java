package _백트래킹_연습문제._1941;

import java.util.*;
import java.io.*;

public class Main {
    static char[][] board = new char[5][5];
    static boolean[] selected = new boolean[25];
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++)
            board[i] = br.readLine().toCharArray();

        func(0, 0, 0);
        System.out.print(cnt);
    }

    static void func(int idx, int count, int sCount) {
        if (count == 7) {
            if (sCount >= 4 && isConnected())
                cnt++;
            return;
        }

        if (idx == 25) return;

        // idx번째 칸 선택
        selected[idx] = true;
        int x = idx / 5;
        int y = idx % 5;
        func(idx + 1, count + 1, sCount + (board[x][y] == 'S' ? 1 : 0));

        // idx번째 칸 선택 안함
        selected[idx] = false;
        func(idx + 1, count, sCount);
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

        Q.add(start);
        visited[start] = true;

        int connectedCount = 1;

        while (!Q.isEmpty()) {
            int cur = Q.poll();
            int x = cur / 5;
            int y = cur % 5;

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                if (OOB(nx, ny)) continue;

                int next = nx * 5 + ny;
                if (!selected[next]) continue;
                if (visited[next]) continue;
                Q.offer(next);
                visited[next] = true;
                connectedCount++;
            }
        }

        return connectedCount == 7;
    }

    static boolean OOB(int nx, int ny) {
        return nx < 0 || nx >= 5 || ny < 0 || ny >= 5;
    }
}
