package BFS_연습문제._9466;

import java.io.*;
import java.util.*;

public class Main_R {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int t, n;
    static int[] student = new int[100002];
    static int[] vis = new int[100002];
    static final int NOT_VISITED = 0;
    static final int VISITED = 1;
    static final int NOT_IN_CYCLE = 2;
    static final int IN_CYCLE = 3;

    public static void main(String[] args) throws IOException {
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());
            Arrays.fill(vis, 1, n+1, NOT_VISITED);
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) student[i] = Integer.parseInt(st.nextToken());

            for (int i = 1; i <= n; i++) {
                if (vis[i] == NOT_VISITED) run(i);
            }

            int sum = 0;
            for (int i = 1; i <= n; i++) {
                if (vis[i] == NOT_IN_CYCLE) sum++;
            }
            System.out.println(sum);
        }
    }

    public static void run(int x) {
        int cur = x;
        while (true) {
            vis[cur] = VISITED;
            cur = student[cur];

            if (vis[cur] == IN_CYCLE || vis[cur] == NOT_IN_CYCLE) {
                cur = x;
                while (vis[cur] == VISITED) {
                    vis[cur] = NOT_IN_CYCLE;
                    cur = student[cur];
                }
                return;
            }

            if (vis[cur] == VISITED && cur == x) {
                while (vis[cur] != IN_CYCLE) {
                    vis[cur] = IN_CYCLE;
                    cur = student[cur];
                }
                return;
            }

            if (vis[cur] == VISITED && cur != x) {
                while (vis[cur] != IN_CYCLE) {
                    vis[cur] = IN_CYCLE;
                    cur = student[cur];
                }

                cur = x;
                while (vis[cur] != IN_CYCLE) {
                    vis[cur] = NOT_IN_CYCLE;
                    cur = student[cur];
                }
                return;
            }
        }
    }
}
