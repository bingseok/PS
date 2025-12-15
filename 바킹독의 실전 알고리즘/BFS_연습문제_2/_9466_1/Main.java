package BFS_연습문제_2._9466_1;

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] board = new int[100002];
    static int[] state = new int[100002];
    static int t, n;
    final static int NOT_VISITED = 0;
    final static int VISITED = 1;
    final static int NOT_IN_CYCLE = 2;
    final static int IN_CYCLE = 3;

    public static void main(String[] args) throws IOException {
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                board[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.fill(state, 1, n+1, NOT_VISITED);

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

    static void run(int x) {
        int cur = x;
        state[cur] = VISITED;
        while (true) {
            cur = board[cur];
            if (state[cur] == IN_CYCLE || state[cur] == NOT_IN_CYCLE) {
                cur = x;
                while (state[cur] == VISITED) {
                    state[cur] = NOT_IN_CYCLE;
                    cur = board[cur];
                }
                break;
            }
            if (state[cur] == VISITED && cur == x) {
                while (state[cur] == VISITED) {
                    state[cur] = IN_CYCLE;
                    cur = board[cur];
                }
                break;
            }
            if (state[cur] == VISITED && cur != x) {
                while (state[cur] == VISITED) {
                    state[cur] = IN_CYCLE;
                    cur = board[cur];
                }
                cur = x;
                while (state[cur] != IN_CYCLE) {
                    state[cur] = NOT_IN_CYCLE;
                    cur = board[cur];
                }
                break;
            }
            state[cur] = VISITED;
        }
    }
}
