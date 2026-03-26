package 스택_연습문제._1874;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static Deque<Integer> DQ = new ArrayDeque<>();
    static int n;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        int cur = 1;
        while (n-- > 0) {
            int k = Integer.parseInt(br.readLine());
            while (cur <= k) {
                DQ.push(cur);
                sb.append("+\n");
                cur++;
            }
            if (DQ.peek() != k) {
                System.out.print("NO");
                return;
            }
            DQ.pop();
            sb.append("-\n");
        }

        System.out.print(sb);
    }


}
