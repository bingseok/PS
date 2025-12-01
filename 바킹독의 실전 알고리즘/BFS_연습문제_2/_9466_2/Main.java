package BFS_연습문제_2._9466_2;

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] board = new int[100002];
    static int[] state = new int[100002];
    static final int NOT_VISITED = 0;
    static final int IN_CYCLE = -1;
    static int t, n;

    public static void main(String[] args) throws IOException {
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                board[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.fill(state, NOT_VISITED);

            for (int i = 1; i <= n; i++) {
                if (state[i] == NOT_VISITED) run(i);
            }

            int ans = 0;
            for (int i = 1; i <= n; i++) {
                if (state[i] != IN_CYCLE) ans++;
            }
            System.out.println(ans);
        }
    }

    static void run(int x) {
        int cur = x;
        while (true) {
            state[cur] = x;
            cur = board[cur];
            if (state[cur] == x) {
                while (state[cur] != IN_CYCLE) {
                    state[cur] = IN_CYCLE;
                    cur = board[cur];
                }
                return;
            }
            else if (state[cur] != NOT_VISITED) return;
        }
    }
}
