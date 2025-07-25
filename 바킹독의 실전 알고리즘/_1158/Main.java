package _1158;

import java.util.*;
import java.io.*;

public class Main {
    static final int MX = 5005;
    static int[] pre = new int[MX];
    static int[] nxt = new int[MX];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder("<");
        int n, k;
        String[] nk = br.readLine().split(" ");
        n = Integer.parseInt(nk[0]);
        k = Integer.parseInt(nk[1]);

        nxt[0] = 1;
        for (int i = 1; i <= n; i++) {
            pre[i] = (i == 1) ? n : i - 1;
            nxt[i] = (i == n) ? 1 : i + 1;
        }

        // 0 1 2 3 4 5 6 7
        int cur = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k-1; j++) {
                cur = nxt[cur];
            }
            answer.append(nxt[cur]);
            nxt[cur] = nxt[nxt[cur]];
            pre[nxt[cur]] = cur;
            if (i < n - 1) answer.append(", ");
        }
        answer.append(">");
        for (char c : answer.toString().toCharArray()) System.out.print(c);
    }
}
