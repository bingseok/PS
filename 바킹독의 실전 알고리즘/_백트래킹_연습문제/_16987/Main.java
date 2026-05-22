package _백트래킹_연습문제._16987;

import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[] s = new int[8];
    static int[] w = new int[8];
    static int ans, cnt; // 깨진 계란의 개수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            s[i] = Integer.parseInt(st.nextToken());
            w[i] = Integer.parseInt(st.nextToken());
        }

        func(0);
        System.out.print(ans);
    }

    // cur번째 계란으로 다른 계란을 꺤다
    static void func(int cur) {
        // n번째의 계란을 모두 들었을 때
        if (cur == n) {
            ans = Math.max(ans, cnt);
            return;
        }

        // 손에 든 계란이 깨졌거나 깨지지 않는 다른 계란이 없을 때
        if (s[cur] <= 0 || cnt == n-1) {
            func(cur+1);
            return;
        }

        // i번째 계란을 깬다
        for (int i = 0; i < n; i++) {
            if (i == cur || s[i] <= 0) continue;
            s[cur] -= w[i];
            s[i] -= w[cur];
            if (s[cur] <= 0) cnt++;
            if (s[i] <= 0) cnt++;
            func(cur+1);
            if (s[cur] <= 0) cnt--;
            if (s[i] <= 0) cnt--;
            s[cur] += w[i];
            s[i] += w[cur];
        }
    }

}
