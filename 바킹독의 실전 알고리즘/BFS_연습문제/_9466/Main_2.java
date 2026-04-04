package BFS_연습문제._9466;

import java.util.*;
import java.io.*;

public class Main_2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int t, n;
    static int[] board = new int[100005];
    static int[] vis = new int[100005];
    final static int NOT_VISITED = 0;
    final static int IN_CYCLE = -1;

    public static void main(String[] args) throws IOException {
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                board[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.fill(vis, 1, n+1, 0);

            for (int i = 1; i <= n; i++) {
                if (vis[i] == NOT_VISITED) run(i);
            }

            int ans = 0;
            for (int i = 1; i <= n; i++) {
                if (vis[i] != IN_CYCLE) ans++;
            }
            sb.append(ans).append("\n");
        }
        System.out.print(sb);
    }

    static void run(int x) {
        int cur = x;
        while (true) {
            vis[cur] = x;
            cur = board[cur];
            if (vis[cur] == x) {
                while (vis[cur] != IN_CYCLE) {
                    vis[cur] = IN_CYCLE;
                    cur = board[cur];
                }
                return;
            }
            else if (vis[cur] != 0) return;
        }
    }
}

