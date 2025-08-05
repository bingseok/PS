package 스택의_활용_수식의_괄호쌍_연습문제._3986;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            Stack<Character> st = new Stack<>();
            String s = br.readLine();
            for (char c : s.toCharArray()) {
                if (st.isEmpty() || st.peek() != c) st.push(c);
                else if (st.peek() == c) st.pop();
            }
            if (st.isEmpty()) answer++;
        }
        System.out.print(answer);
    }

}
