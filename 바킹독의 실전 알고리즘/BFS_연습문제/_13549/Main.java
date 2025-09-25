package BFS_연습문제._13549;


import java.io.*;
import java.util.*;

import java.io.IOException;

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
            if (2*cur <= MX && dist[2*cur] == -1) {
                dist[2*cur] = dist[cur];
                DQ.addFirst(2*cur);
            }

            // 양옆으로 이동
            int[] dir = {cur-1, cur+1};
            for (int x : dir) {
                if (x < 0 || x > MX || dist[x] != -1) continue;
                dist[x] = dist[cur] + 1;
                DQ.addLast(x);
            }
        }

        System.out.print(dist[k]);
    }
}
