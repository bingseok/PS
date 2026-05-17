package _백트래킹_연습문제._6603;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[] arr = new int[20];
    static int[] res = new int[7];
    static int k;

    public static void main(String[] args) throws IOException {
        while (true) {
            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            if (k == 0) {
                System.out.print(sb);
                return;
            }

            for (int i = 0; i < k; i++) arr[i] = Integer.parseInt(st.nextToken());
            Arrays.sort(arr, 0, k);
            func(0, 0);
            sb.append("\n");
        }
    }

    static void func(int cur, int st) {
        if (cur == 6) {
            for (int i = 0; i < 6; i++) sb.append(res[i]).append(" ");
            sb.append("\n");
            return;
        }

        for (int i = st; i < k; i++) {
            res[cur] = arr[i];
            func(cur+1, i+1);
        }
    }
}
