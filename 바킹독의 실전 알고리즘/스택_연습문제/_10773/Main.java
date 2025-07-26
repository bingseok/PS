package 스택_연습문제._10773;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> st = new Stack<>();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int k = Integer.parseInt(br.readLine());
            if (k == 0) st.pop();
            else st.push(k);
        }

        int answer = 0;
        while (!st.empty()) {
            answer += st.peek();
            st.pop();
        }
        System.out.print(answer);
    }
}
