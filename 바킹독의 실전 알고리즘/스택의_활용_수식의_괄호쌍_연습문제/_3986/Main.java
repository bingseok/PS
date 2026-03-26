package 스택의_활용_수식의_괄호쌍_연습문제._3986;

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int ans = 0;
        while (n-- > 0) {
            String s = br.readLine();
            Deque<Character> ST = new ArrayDeque<>();

            for (char c : s.toCharArray()) {
                if (ST.isEmpty() || ST.peek() != c) ST.push(c);
                else ST.pop();
            }

            if (ST.isEmpty()) ans++;
        }
        System.out.print(ans);
    }

}
