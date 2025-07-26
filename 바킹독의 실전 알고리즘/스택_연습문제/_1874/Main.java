package 스택_연습문제._1874;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        Stack<Integer> st = new Stack<>();
        int cur = 1;
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int k = Integer.parseInt(br.readLine());
            for (; cur <= k; cur++) {
                st.push(cur);
                answer.append("+").append("\n");
            }
            if (st.peek() != k) {
                System.out.print("NO"); return;
            }
            answer.append("-").append("\n");
            st.pop();
        }

        System.out.print(answer);
    }
}
