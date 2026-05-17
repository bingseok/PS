package _백트래킹_연습문제._15657_1;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int n, m;
    static int[] arr = new int[10];
    static int[] idx = new int[10];

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        func(0, 0);
        System.out.print(sb);
    }

    static void func(int cur, int start) {
        if (cur == m) {
            for (int i = 0; i < m; i++) sb.append(arr[idx[i]]).append(" ");
            sb.append("\n");
            return;
        }

        for (int i = start; i < n; i++) {
            idx[cur] = i;
            func(cur+1, i);
        }
    }
}
