package _백트래킹_연습문제._15654;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[] arr = new int[10];
    static int[] res = new int[10];
    static boolean[] isused = new boolean[10];
    static int n, m;


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

        for (int i = 0; i < n; i++) {
            if (isused[i]) continue;
            isused[i] = true;
            res[cur] = arr[i];
            func(cur+1);
            isused[i] = false;
        }
    }
}
