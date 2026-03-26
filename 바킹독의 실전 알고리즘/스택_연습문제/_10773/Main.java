package 스택_연습문제._10773;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static Deque<Integer> DQ = new ArrayDeque<>();
    static int k;

    public static void main(String[] args) throws IOException {
        k = Integer.parseInt(br.readLine());
        while (k-- > 0) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) DQ.pop();
            else DQ.push(n);
        }

        int ans = 0;
        while (!DQ.isEmpty()) {
            ans += DQ.peek();
            DQ.pop();
        }

        System.out.print(ans);
    }


}
