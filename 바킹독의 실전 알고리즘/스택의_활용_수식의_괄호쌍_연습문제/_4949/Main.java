package 스택의_활용_수식의_괄호쌍_연습문제._4949;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        while (true) {
            String s = br.readLine();
            if (s.equals(".")) break;
            Stack<Character> st = new Stack<>();
            boolean isValid = true;
            for (char c : s.toCharArray()) {
                if (c == '(' || c == '[') st.push(c);
                else if (c == ')') {
                    if (st.isEmpty() || st.peek() != '(') {
                        isValid = false;
                        break;
                    }
                    st.pop();
                }
                else if (c == ']') {
                    if (st.isEmpty() || st.peek() != '[') {
                        isValid = false;
                        break;
                    }
                    st.pop();
                }
            }
            if (!st.isEmpty()) isValid = false;
            if (isValid) sb.append("yes\n");
            else sb.append("no\n");
        }
        System.out.print(sb);
    }

}
