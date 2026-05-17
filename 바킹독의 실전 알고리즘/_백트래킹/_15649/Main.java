package _백트래킹._15649;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int n, m;
    static int[] ans = new int[10];
    static boolean[] isused = new boolean[10];

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        func(0);
        System.out.print(sb);
    }

    static void func(int k) {
        if (k == m) {
            for (int i = 0; i < m; i++)
                sb.append(ans[i]);
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!isused[i]) {
                ans[k] = i;
                isused[i] = true;
                func(k+1);
                isused[i] = false;
            }
        }
    }
}
