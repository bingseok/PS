package _백트래킹_연습문제._1182;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int n, s;
    static int[] arr = new int[30];
    static int cnt;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        func(0, 0);
        if (s == 0) cnt--;
        System.out.print(cnt);
    }

    static void func(int cur, int sum) {
        if (cur == n) {
            if (sum == s) cnt++;
            return;
        }

        func(cur+1, sum);
        func(cur+1, sum+arr[cur]);
    }
}
