package 스택의_활용_수식의_괄호쌍_연습문제._4949;


import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        while (true) {
            String s = br.readLine();
            if (s.equals(".")) {
                System.out.print(sb);
                return;
            }

            Deque<Character> ST = new ArrayDeque<>();
            boolean isValid = true;
            for (char c : s.toCharArray()) {
                if (c == '(' || c == '[') ST.push(c);
                else if (c == ')') {
                    if (ST.isEmpty() || ST.peek() != '(') {
                        isValid = false;
                        break;
                    }
                    ST.pop();
                }
                else if (c == ']') {
                    if (ST.isEmpty() || ST.peek() != '[') {
                        isValid = false;
                        break;
                    }
                    ST.pop();
                }
            }

            if (!ST.isEmpty()) isValid = false;
            if (isValid) sb.append("yes\n");
            else sb.append("no\n");
        }
    }

}
