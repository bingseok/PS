package 연결_리스트_연습문제._1158;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static ArrayList<Integer> ans = new ArrayList<>();
    static int n, k;
    static int[] nxt = new int[5005];
    static int[] pre = new int[5005];
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        nxt[0] = 1;
        for (int i = 1; i <= n; i++) {
            nxt[i] = i == n ? 1 : i + 1;
            pre[i] = i == 1 ? n : i - 1;
        }

        // 1 2 3 4 5 6 7
        int cur = 0;
        while (ans.size() != n) {
            for (int i = 0; i < k; i++) {
                cur = nxt[cur];
            }
            ans.add(cur);
            pre[nxt[cur]] = pre[cur];
            nxt[pre[cur]] = nxt[cur];
        }


        traverse();


    }

    static void traverse() {
        sb.append("<");
        for (int i = 0; i < ans.size(); i++) {
            sb.append(ans.get(i));
            if (i != ans.size() - 1) sb.append(", ");
        }
        sb.append(">");

        System.out.print(sb);
    }
}
