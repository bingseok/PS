package BFS_연습문제_2._1697;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    final static int L = 200002;
    static int[] dist = new int[L];
    static int n, k;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        Arrays.fill(dist, -1);
        Queue<Integer> Q = new ArrayDeque<>();
        Q.add(n);
        dist[n] = 0;

        while (dist[k] == -1) {
            int cur = Q.peek(); Q.remove();
            int[] dir = {cur+1, cur-1, 2*cur};
            for (int x : dir) {
                if (x < 0 || x >= L) continue;
                if (dist[x] != -1) continue;
                Q.add(x);
                dist[x] = dist[cur] + 1;
            }
        }

        System.out.print(dist[k]);
    }
}