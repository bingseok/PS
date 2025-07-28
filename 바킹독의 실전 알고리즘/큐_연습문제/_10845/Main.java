package 큐_연습문제._10845;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();

        int n = Integer.parseInt(br.readLine());
        int last = 0;
        for (int i = 0; i < n; i++) {
            String cmd = br.readLine();
            if (cmd.startsWith("push")) {
                last = Integer.parseInt(cmd.split(" ")[1]);
                queue.add(last);
            }
            else if (cmd.equals("pop")) {
                if (queue.isEmpty()) answer.append(-1);
                else {
                    answer.append(queue.peek());
                    queue.remove();
                }
                answer.append("\n");
            }
            else if (cmd.equals("size"))
                answer.append(queue.size()).append("\n");
            else if (cmd.equals("empty"))
                answer.append(queue.isEmpty() ? 1 : 0).append("\n");
            else if (cmd.equals("front"))
                answer.append(queue.isEmpty() ? -1 : queue.peek()).append("\n");
            else
                answer.append(queue.isEmpty() ? -1 : last).append("\n");
        }

        System.out.print(answer);
    }
}