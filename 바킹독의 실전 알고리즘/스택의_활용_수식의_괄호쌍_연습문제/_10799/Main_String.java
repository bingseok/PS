package 스택의_활용_수식의_괄호쌍_연습문제._10799;

import java.util.*;
import java.io.*;

public class Main_String {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        String s = br.readLine();
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') st.push(s.charAt(i));
            else {
                if (s.charAt(i-1) == '(') {
                    st.pop();
                    answer += st.size();
                }
                else {
                    st.pop();
                    answer++;
                }
            }
        }
        System.out.print(answer);
    }

}
