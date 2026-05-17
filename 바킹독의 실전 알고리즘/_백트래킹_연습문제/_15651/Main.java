package _백트래킹_연습문제._15651;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static boolean[] isused = new boolean[10];
    static int[] ans = new int[10];
    static int n, m;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        func(0);
        System.out.print(sb);
    }

    static void func(int cur) {
        if (cur == m) {
            for (int i = 0; i < m; i++) sb.append(ans[i]).append(" ");
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            ans[cur] = i;
            func(cur+1);
        }
    }
}
