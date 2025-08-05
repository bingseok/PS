package 스택의_활용_수식의_괄호쌍_연습문제._10799;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        String s = br.readLine();
        Stack<Character> st = new Stack<>();
        int res = 0;
        char prev = ' ';
        for (char cur : s.toCharArray()) {
            if (cur == '(') {
                st.push(cur);
                res++;
            }
            else {
                if (prev == '(') {
                    st.pop();
                    res--;
                    answer += res;
                }
                else {
                    st.pop();
                    res--;
                    answer++;
                }
            }
            prev = cur;
        }

        System.out.print(answer);
    }
}
