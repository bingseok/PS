package BFS_연습문제_2._9466_1;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] board = new int[100002];
    static int[] state = new int[100002];
    static final int NOT_VISITED = 0;
    static final int VISITED = 1;
    static final int NOT_IN_CYCLE = 2;
    static final int IN_CYCLE = 3;
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
                if (state[i] == NOT_IN_CYCLE) ans++;
            }
            System.out.println(ans);
        }
    }

    static void run(int i) {
        int cur = i;
        while (true) {
            state[cur] = VISITED;
            cur = board[cur];
            if (state[cur] == NOT_IN_CYCLE || state[cur] == IN_CYCLE) {
                cur = i;
                while (state[cur] == VISITED) {
                    state[cur] = NOT_IN_CYCLE;
                    cur = board[cur];
                }
                return;
            }
            if (state[cur] == VISITED && cur == i) {
                while (state[cur] != IN_CYCLE) {
                    state[cur] = IN_CYCLE;
                    cur = board[cur];
                }
                return;
            }
            if (state[cur] == VISITED && cur != i) {
                while (state[cur] != IN_CYCLE) {
                    state[cur] = IN_CYCLE;
                    cur = board[cur];
                }
                cur = i;
                while (state[cur] != IN_CYCLE) {
                    state[cur] = NOT_IN_CYCLE;
                    cur = board[cur];
                }
                return;
            }
        }
    }
}
