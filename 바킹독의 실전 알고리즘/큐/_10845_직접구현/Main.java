package 큐._10845_직접구현;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    final static int MX = 10005;
    static int[] dat = new int[MX];
    static int head, tail;
    static int n;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            String op = st.nextToken();
            if (op.equals("push")) {
                push(Integer.parseInt(st.nextToken()));
            }
            else if (op.equals("pop")) {
                if (empty() == 1) sb.append("-1\n");
                else {
                    sb.append(front()).append("\n");
                    pop();
                }
            }
            else if (op.equals("size")) {
                sb.append(size()).append("\n");
            }
            else if (op.equals("empty")) {
                sb.append(empty()).append("\n");
            }
            else if (op.equals("front")) {
                if (empty() == 1) sb.append("-1\n");
                else sb.append(front()).append("\n");
            }
            else if (op.equals("back")) {
                if (empty() == 1) sb.append("-1\n");
                else sb.append(back()).append("\n");
            }
        }

        System.out.print(sb);
    }

    static void push(int x) {
        dat[tail++] = x;
    }

    static void pop() {
        head++;
    }

    static int size() {
        return tail - head;
    }

    static int empty() {
        return head == tail ? 1 : 0;
    }

    static int front() {
        return dat[head];
    }

    static int back() {
        return dat[tail - 1];
    }
}
