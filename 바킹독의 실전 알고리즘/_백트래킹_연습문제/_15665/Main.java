package _백트래킹_연습문제._15665;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int n, m;
    static int[] arr = new int[10];
    static int[] res = new int[10];

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr, 0, n);

        func(0);
        System.out.print(sb);
    }

    static void func(int cur) {
        if (cur == m) {
            for (int i = 0; i < m; i++) sb.append(res[i]).append(" ");
            sb.append("\n");
            return;
        }

        int tmp = 0;
        for (int i = 0; i < n; i++) {
            if (tmp == arr[i]) continue;
            res[cur] = arr[i];
            tmp = res[cur];
            func(cur+1);
        }
    }
}
