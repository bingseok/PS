package BFS_연습문제._9466_1;

import java.io.*;
import java.util.*;

public class Main_R {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int t, n;
    static int[] arr = new int[100002];
    static int[] vis = new int[100002];
    final static int NOT_VISITED = 0;
    final static int IN_CYCLE = -1;

    public static void main(String[] args) throws IOException {
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());
            Arrays.fill(vis, 1, n+1, NOT_VISITED);
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) arr[i] = Integer.parseInt(st.nextToken());

            for (int i = 1; i <= n; i++) {
                if (vis[i] == NOT_VISITED) run(i);
            }

            int sum = 0;
            for (int i = 1; i <= n; i++) {
                if (vis[i] != IN_CYCLE) sum++;
            }
            System.out.println(sum);
        }
    }

    public static void run(int x) {
        int cur = x;
        while (true) {
            vis[cur] = x;
            cur = arr[cur];

            if (vis[cur] == x) {
                while (vis[cur] != IN_CYCLE) {
                    vis[cur] = IN_CYCLE;
                    cur = arr[cur];
                }
            }
            else if (vis[cur] != NOT_VISITED) return;
        }
    }
}
