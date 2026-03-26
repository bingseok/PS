package 덱_연습문제._10866_직접구현;

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    final static int MX = 10005;
    static int[] dat = new int[2*MX + 1];
    static int head = MX, tail = MX;
    static int n;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            String op = st.nextToken();
            if (op.equals("push_front")) {
                push_front(Integer.parseInt(st.nextToken()));
            }
            else if (op.equals("push_back")) {
                push_back(Integer.parseInt(st.nextToken()));
            }
            else if (op.equals("pop_front")) {
                if (empty() == 1) sb.append(-1);
                else {
                    sb.append(front());
                    pop_front();
                }
                sb.append("\n");
            }
            else if (op.equals("pop_back")) {
                if (empty() == 1) sb.append(-1);
                else {
                    sb.append(back());
                    pop_back();
                }
                sb.append("\n");
            }
            else if (op.equals("size")) sb.append(size()).append("\n");
            else if (op.equals("empty")) sb.append(empty()).append("\n");
            else if (op.equals("front")) {
                if (empty() == 1) sb.append("-1");
                else sb.append(front());
                sb.append("\n");
            }
            else if (op.equals("back")) {
                if (empty() == 1) sb.append("-1");
                else sb.append(back());
                sb.append("\n");

            }
        }

        System.out.print(sb);
    }

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

    static int empty() {
        return tail == head ? 1 : 0;
    }

    static int front() {
        return dat[head];
    }

    static int back() {
        return dat[tail-1];
    }


}
