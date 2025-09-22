package BFS_연습문제._13549;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] dist = new int[100005];
    static int n, k;
    final static int MX = 100000;
    static Deque<Integer> DQ = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        Arrays.fill(dist, -1);
        DQ.addLast(n);
        dist[n] = 0;

        while (!DQ.isEmpty() && dist[k] == -1) {
            int cur = DQ.peekFirst(); DQ.removeFirst();
            // 순간이동
            if (2 * cur <= MX && dist[2*cur] == -1) {
                dist[2*cur] = dist[cur];
                DQ.addFirst(2*cur);
            }

            // +-1
            int[] dir = {cur-1, cur+1};
            for (int nxt: dir) {
                if (nxt < 0 || nxt > MX || dist[nxt] != -1) continue;
                dist[nxt] = dist[cur] + 1;
                DQ.addLast(nxt);
            }
        }
        System.out.print(dist[k]);
    }
}
