package 스택_연습문제._10828;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        Stack<Integer> st = new Stack<>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String cmd = br.readLine();
            if (cmd.startsWith("push")) {
                st.push(Integer.parseInt(cmd.split(" ")[1]));
            }
            else if (cmd.equals("pop")) {
                if (st.empty()) answer.append(-1).append("\n");
                else {
                    answer.append(st.peek()).append("\n");
                    st.pop();
                }
            }
            else if (cmd.equals("size")) {
                answer.append(st.size()).append("\n");
            }
            else if (cmd.equals("empty")) {
                answer.append(st.empty() ? 1 : 0).append("\n");
            }
            else if (cmd.equals("top")) {
                answer.append(st.empty() ? -1 : st.peek()).append("\n");
            }
        }

        System.out.print(answer);
    }
}
