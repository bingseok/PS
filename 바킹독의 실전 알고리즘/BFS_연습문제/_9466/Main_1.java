package BFS_연습문제._9466;

import java.util.*;
import java.io.*;

public class Main_1 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[] board = new int[100005];
    static int[] vis = new int[100005];
    static int t;
    final static int NOT_VISITED = 0, VISITED = 1, IN_CYCLE = 2, NOT_IN_CYCLE = 3;

    public static void main(String[] args) throws IOException {

        // 1. 아직 방문 안한 학생이면 RUN

        // 2. 진행하면서 NOT_VISITED인 학생은 VISITED로 변경

        // 3. 진행 중 IN_CYCLE, NOT_IN_CYCLE을 만나면 그 전까지 학생들은 NOT_IN_CYCLE

        // 4. 처음 학생을 다시 만나면, IN_CYCLE

        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            Arrays.fill(vis, 1, n+1, 0);
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                board[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= n; i++) {
                if (vis[i] == NOT_VISITED) run(i);
            }

            int cnt = 0;
            for (int i = 1; i <= n; i++) {
                if (vis[i] == NOT_IN_CYCLE) cnt++;
            }
            sb.append(cnt).append("\n");

        }
        System.out.print(sb);
    }

    static void run(int x) {
        int cur = x;
        while (true) {
            vis[cur] = VISITED;
            cur = board[cur];
            if (vis[cur] == NOT_IN_CYCLE || vis[cur] == IN_CYCLE) {
                cur = x;
                while (vis[cur] == VISITED) {
                    vis[cur] = NOT_IN_CYCLE;
                    cur = board[cur];
                }
                break;
            }
            if (vis[cur] == VISITED) {
                while (vis[cur] == VISITED) {
                    vis[cur] = IN_CYCLE;
                    cur = board[cur];
                }
                cur = x;
                while (vis[cur] == VISITED) {
                    vis[cur] = NOT_IN_CYCLE;
                    cur = board[cur];
                }
                break;
            }
        }
    }

}
