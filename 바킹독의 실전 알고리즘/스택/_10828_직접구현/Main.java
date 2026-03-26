package 스택._10828_직접구현;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    final static int MX = 10005;
    static int[] dat = new int[MX];
    static int pos = 0;
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
                if (empty() == 1) {
                    sb.append("-1\n");
                }
                else {
                    sb.append(top()).append("\n");
                    pop();
                }
            }
            else if (op.equals("size")) {
                sb.append(size()).append("\n");
            }
            else if (op.equals("empty")) {
                sb.append(empty()).append("\n");
            }
            else if (op.equals("top")) {
                if (empty() == 1) sb.append("-1\n");
                else sb.append(top()).append("\n");
            }
        }

        System.out.print(sb);
    }

    static void push(int x) {
        dat[pos++] = x;
    }

    static void pop() {
        pos--;
    }

    static int size() {
        return pos;
    }

    static int empty() {
        return pos == 0 ? 1 : 0;
    }

    static int top() {
        return dat[pos-1];
    }
}
