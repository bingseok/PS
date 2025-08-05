package 스택의_활용_수식의_괄호_쌍._4949;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        while (true) {
            String input = br.readLine();
            if (input.equals(".")) break;
            Stack<Character> st = new Stack<>();
            boolean isNo = false;
            for (char c : input.toCharArray()) {
                if (c == '(' || c == '[') st.push(c);
                else if (c == ')' || c == ']') {
                    if (st.isEmpty()) {
                        isNo = true;
                        break;
                    }
                    char tmp = st.peek();
                    if ((c == ')' && tmp == '(') || (c == ']' && tmp == '[')) st.pop();
                    else {
                        isNo = true;
                        break;
                    }
                }
            }
            if (!st.isEmpty()) isNo = true;
            if (isNo) sb.append("no\n");
            else sb.append("yes\n");
        }
        System.out.print(sb);
    }
}
