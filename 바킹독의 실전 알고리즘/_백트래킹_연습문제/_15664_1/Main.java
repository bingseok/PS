package _백트래킹_연습문제._15664_1;

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
        Arrays.sort(arr, 0, n);
        func(0,  0);
        System.out.print(sb);
    }

    static void func(int cur, int st) {
        if (cur == m) {
            for (int i = 0; i < m; i++) sb.append(arr[idx[i]]).append(" ");
            sb.append("\n");
            return;
        }

        int tmp = 0;
        for (int i = st; i < n; i++) {
            if (tmp == arr[i]) continue;
            idx[cur] = i;
            tmp = arr[i];
            func(cur+1, i+1);
        }
    }
}
