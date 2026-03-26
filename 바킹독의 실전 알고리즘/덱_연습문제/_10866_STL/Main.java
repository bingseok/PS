package 덱_연습문제._10866_STL;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static Deque<Integer> DQ = new ArrayDeque<>();
    static int n;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            String op = st.nextToken();
            if (op.equals("push_back")) {
                DQ.add(Integer.parseInt(st.nextToken()));
            }
            else if (op.equals("push_front")) {
                DQ.addFirst(Integer.parseInt(st.nextToken()));
            }
            else if (op.equals("pop_front")) {
                if (DQ.isEmpty()) sb.append("-1\n");
                else {
                    sb.append(DQ.peek()).append("\n");
                    DQ.remove();
                }
            }
            else if (op.equals("pop_back")) {
                if (DQ.isEmpty()) sb.append("-1\n");
                else {
                    sb.append(DQ.peekLast()).append("\n");
                    DQ.removeLast();
                }
            }
            else if (op.equals("size")) sb.append(DQ.size()).append("\n");
            else if (op.equals("empty")) sb.append(DQ.isEmpty() ? 1 : 0).append("\n");
            else if (op.equals("front")) {
                if (DQ.isEmpty()) sb.append("-1\n");
                else sb.append(DQ.peek()).append("\n");
            }
            else if (op.equals("back")) {
                if (DQ.isEmpty()) sb.append("-1\n");
                else sb.append(DQ.peekLast()).append("\n");
            }
        }
        System.out.print(sb);
    }
}
