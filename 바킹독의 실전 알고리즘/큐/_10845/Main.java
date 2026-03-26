package 큐._10845;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static Deque<Integer> Q = new ArrayDeque<>();
    static int n;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            String op = st.nextToken();
            if (op.equals("push")) {
                Q.add(Integer.parseInt(st.nextToken()));
            }
            else if (op.equals("pop")) {
                if (Q.isEmpty()) sb.append("-1\n");
                else {
                    sb.append(Q.peek()).append("\n");
                    Q.remove();
                }
            }
            else if (op.equals("size"))
                sb.append(Q.size()).append("\n");
            else if (op.equals("empty"))
                sb.append(Q.isEmpty() ? 1 : 0).append("\n");
            else if (op.equals("front")) {
                if (Q.isEmpty()) sb.append("-1\n");
                else {
                    sb.append(Q.peek()).append("\n");
                }
            }
            else if (op.equals("back")) {
                if (Q.isEmpty()) sb.append("-1\n");
                else  {
                    sb.append(Q.peekLast()).append("\n");
                }
            }
        }

        System.out.print(sb);
    }

}
