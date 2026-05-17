package _백트래킹_연습문제._15663;


import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int n, m;
    static int[] arr = new int[10];
    static int[] idx = new int[10];
    static boolean[] isused = new boolean[10];
    static Set<String> freq = new LinkedHashSet<>();

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
            String s = "";
            for (int i= 0; i < m; i++) s = s + arr[idx[i]] + " ";
            if (!freq.add(s)) return;
            sb.append(s).append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            if (isused[i]) continue;
            idx[cur] = i;
            isused[i] = true;
            func(cur+1);
            isused[i] = false;
        }
    }
}
