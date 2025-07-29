package 덱_연습문제._10866;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> dq = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String cmd = br.readLine();
            if (cmd.startsWith("push_front")) {
                dq.addFirst(Integer.parseInt(cmd.split(" ")[1]));
            }
            else if (cmd.startsWith("push_back")) {
                dq.addLast(Integer.parseInt(cmd.split(" ")[1]));
            }
            else if (cmd.equals("pop_front")) {
                if (dq.isEmpty()) sb.append(-1).append("\n");
                else {
                    sb.append(dq.peekFirst()).append("\n");
                    dq.removeFirst();
                }
            }
            else if (cmd.equals("pop_back")) {
                if (dq.isEmpty()) sb.append(-1).append("\n");
                else {
                    sb.append(dq.peekLast()).append("\n");
                    dq.removeLast();
                }
            }
            else if (cmd.equals("size"))
                sb.append(dq.size()).append("\n");
            else if (cmd.equals("empty"))
                sb.append(dq.isEmpty() ? 1 : 0).append("\n");
            else if (cmd.equals("front"))
                sb.append(dq.isEmpty() ? -1 : dq.peekFirst()).append("\n");
            else sb.append(dq.isEmpty() ? -1 : dq.peekLast()).append("\n");
        }
        System.out.print(sb);
    }
}
