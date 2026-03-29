package BFS_연습문제._1697;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static Deque<Integer> Q = new ArrayDeque<>();
    static int[] dist = new int[100005];
    static int n, k;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        Arrays.fill(dist, -1);
        dist[n] = 0;
        Q.add(n);

        while (dist[k] == -1) {
            int cur = Q.peek(); Q.remove();
            int[] dir = {cur-1, cur+1, 2*cur};
            for (int nxt : dir) {
                if (nxt < 0 || nxt > 100000) continue;
                if (dist[nxt] != -1) continue;
                dist[nxt] = dist[cur] + 1;
                Q.add(nxt);
            }
        }

        System.out.print(dist[k]);
    }

}
