package 스택의_활용_수식의_괄호쌍_연습문제._10799;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        String s = br.readLine();
        Deque<Character> ST = new ArrayDeque<>();

        char prev = ' ';
        int ans = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') ST.push(c);
            else if (c == ')') {
                // 레이저인 경우
                if (prev == '(') {
                    ST.pop();
                    ans += ST.size();
                }
                // 막대의 끝인 경우
                else {
                    ST.pop();
                    ans++;
                }
            }
            prev = c;
        }

        System.out.print(ans);
    }

}
