package 덱._10866;

import java.util.*;
import java.io.*;

public class Main {
    static final int MX = 10005;
    static int[] dat = new int[2*MX + 1];
    static int head = MX, tail = MX;

    static void push_front(int x) {
        dat[--head] = x;
    }
    static void push_back(int x) {
        dat[tail++] = x;
    }
    static void pop_front() {
        head++;
    }
    static void pop_back() {
        tail--;
    }
    static int size() {
        return tail - head;
    }
    static boolean empty() {
        return tail == head;
    }
    static int front() {
        return dat[head];
    }
    static int back() {
        return dat[tail-1];
    }
    /**
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String cmd = br.readLine();
            if (cmd.startsWith("push_front")) push_front(Integer.parseInt(cmd.split(" ")[1]));
            else if (cmd.startsWith("push_back")) push_back(Integer.parseInt(cmd.split(" ")[1]));
            else if (cmd.equals("pop_front")) {
                if (empty()) sb.append(-1).append("\n");
                else {
                    sb.append(front()).append("\n");
                    pop_front();
                }
            }
            else if (cmd.equals("pop_back")) {
                if (empty()) sb.append(-1).append("\n");
                else {
                    sb.append(back()).append("\n");
                    pop_back();
                }
            }
            else if (cmd.equals("size")) sb.append(size()).append("\n");
            else if (cmd.equals("empty")) sb.append(empty() ? 1 : 0).append("\n");
            else if (cmd.equals("front")) sb.append(empty() ? -1 : front()).append("\n");
            else if (cmd.equals("back")) sb.append(empty() ? -1 : back()).append("\n");
        }
        System.out.print(sb);
    }
     **/

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Deque<Integer> DQ = new LinkedList<>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String cmd = br.readLine();
            if (cmd.startsWith("push_front"))
                DQ.addFirst(Integer.parseInt(cmd.split(" ")[1]));
            else if (cmd.startsWith("push_back"))
                DQ.addLast(Integer.parseInt(cmd.split(" ")[1]));
            else if (cmd.equals("pop_front")) {
                if (DQ.isEmpty()) sb.append(-1).append("\n");
                else {
                    sb.append(DQ.peekFirst()).append("\n");
                    DQ.removeFirst();
                }
            }
            else if (cmd.equals("pop_back")) {
                if (DQ.isEmpty()) sb.append(-1).append("\n");
                else {
                    sb.append(DQ.peekLast()).append("\n");
                    DQ.removeLast();
                }
            }
            else if (cmd.equals("size"))
                sb.append(DQ.size()).append("\n");
            else if (cmd.equals("empty"))
                sb.append(DQ.isEmpty() ? 1 : 0).append("\n");
            else if (cmd.equals("front"))
                sb.append(DQ.isEmpty() ? -1 : DQ.peekFirst()).append("\n");
            else sb.append(DQ.isEmpty() ? -1 : DQ.peekLast()).append("\n");
        }
        System.out.print(sb);
    }
}
