package BFS._1697;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] dist = new int[100005];
    static int n, k;
    static Queue<Integer> Q = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        Arrays.fill(dist, -1);

        Q.add(n);
        dist[n] = 0;

        while (dist[k] == -1) {
            int cur = Q.peek(); Q.remove();
            int[] nx = {cur+1, cur-1, 2*cur};
            for (int x : nx) {
                if (x < 0 || x > 100000) continue;
                if (dist[x] != -1) continue;
                Q.add(x);
                dist[x] = dist[cur] + 1;
            }
        }
        System.out.print(dist[k]);
    }
}
