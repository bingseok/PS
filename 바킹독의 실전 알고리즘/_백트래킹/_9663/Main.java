package _백트래킹._9663;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int cnt = 0;
    static boolean[] isused1 = new boolean[40]; // 같은 열인지
    static boolean[] isused2 = new boolean[40]; // 오른쪽 대각선인지
    static boolean[] isused3 = new boolean[40]; // 왼쪽 대각선인지

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        func(0);
        System.out.print(cnt);
    }

    static void func(int cur) {
        if (cur == n) {
            cnt++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!isused1[i] && !isused2[cur+i] && !isused3[cur-i+n-1]) {
                isused1[i] = true;
                isused2[cur+i] = true;
                isused3[cur-i+n-1] = true;
                func(cur+1);
                isused1[i] = false;
                isused2[cur+i] = false;
                isused3[cur-i+n-1] = false;
            }
        }

    }

}
