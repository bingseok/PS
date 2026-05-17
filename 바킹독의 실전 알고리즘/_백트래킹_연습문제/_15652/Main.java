package _백트래킹_연습문제._15652;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int n, m;
    static int[] ans = new int[10];

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

        int st = 1;
        if (cur != 0) st = ans[cur-1];
        for (int i = st; i <= n; i++) {
            ans[cur] = i;
            func(cur+1);
        }
    }
}
