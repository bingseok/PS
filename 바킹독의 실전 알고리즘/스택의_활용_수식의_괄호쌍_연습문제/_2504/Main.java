package 스택의_활용_수식의_괄호쌍_연습문제._2504;

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        String s = br.readLine();
        Deque<Character> ST = new ArrayDeque<>();

        int res = 1;
        int ans = 0;
        boolean isValid = true;
        for (int i = 0; i < s.toCharArray().length; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                res *= 2;
                ST.push(c);
            }
            else if (c == '[') {
                res *= 3;
                ST.push(c);
            }
            else if (c == ')') {
                if (ST.isEmpty() || ST.peek() != '(') {
                    isValid = false;
                    break;
                }
                if (s.charAt(i-1) == '(') {
                    ans += res;
                }
                ST.pop();
                res /= 2;
            }
            else if (c == ']') {
                if (ST.isEmpty() || ST.peek() != '[') {
                    isValid = false;
                    break;
                }
                if (s.charAt(i-1) == '[') {
                    ans += res;
                }
                ST.pop();
                res /= 3;
            }
        }

        if (!ST.isEmpty()) isValid = false;
        if (isValid) System.out.print(ans);
        else System.out.print(0);
    }
}
