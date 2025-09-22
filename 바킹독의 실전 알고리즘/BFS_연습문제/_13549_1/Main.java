package BFS_연습문제._13549_1;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] dist = new int[100005];
    static int n, k;
    final static int MX = 100000;
    static Queue<Integer> Q = new ArrayDeque<>();

    static void teleport(int cur) {
        int tmp = cur;
        if (tmp == 0) return;
        while (tmp <= MX && dist[k] == -1) {
            if (dist[tmp] == -1) {
                dist[tmp] = dist[cur];
                Q.add(tmp);
            }
            tmp *= 2;
        }
    }
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        Arrays.fill(dist, -1);
        Q.add(n);
        dist[n] = 0;
        teleport(n);

        while (dist[k] == -1) {
            int cur = Q.peek(); Q.remove();
            int[] dir = {cur+1, cur-1};
            for (int k: dir) {
                if (k < 0 || k > MX) continue;
                if (dist[k] != -1) continue;
                dist[k] = dist[cur] + 1;
                Q.add(k);
                teleport(k);
            }
        }
        System.out.print(dist[k]);
    }
}
