package BFS_연습문제._9466_1;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, t;
    static int[] arr = new int[100002];
    static int[] state = new int[100002];
    final static int NOT_VISITED = 0;
    final static int IN_CYCLE = -1;

    public static void main(String[] args) throws IOException {
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());
            Arrays.fill(state, 1, n+1, 0);
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) arr[i] = Integer.parseInt(st.nextToken());

            for (int i = 1; i <= n; i++) {
                if (state[i] == NOT_VISITED) run(i);
            }

            int sum = 0;
            for (int i = 1; i <= n; i++) {
                if (state[i] != IN_CYCLE) sum++;
            }
            System.out.println(sum);
        }
    }

    static void run(int x) {
        int cur = x;
        while (true) {
            state[cur] = x;
            cur = arr[cur];

            // 이번 방문에서 지나간 학생에 도달했을 경우 (2번, 3번 케이스)
            if (state[cur] == x) {
                while (state[cur] != IN_CYCLE) {
                    state[cur] = IN_CYCLE;
                    cur = arr[cur];
                }
                return;
            }
            // 이전 방문에서 지나간 학생에 도달했을 경우 (1번 케이스)
            else if (state[cur] != NOT_VISITED) return;
        }
    }
}


















