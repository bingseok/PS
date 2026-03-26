package 연결_리스트_연습문제._1406_직접구현;

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static String input;
    final static int MX = 600005;
    static char[] dat = new char[MX];
    static int[] pre = new int[MX];
    static int[] nxt = new int[MX];
    static int unused = 1;
    static int cursor;
    static int n;

    public static void main(String[] args) throws IOException {
        Arrays.fill(pre, -1);
        Arrays.fill(nxt, -1);
        input = br.readLine();

        for (int i = 0; i < input.length(); i++) {
            insert(cursor, input.charAt(i));
            cursor++;
        }

        n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            String op = st.nextToken();
            if (op.equals("L")) {
                if (pre[cursor] != -1) cursor = pre[cursor];
            }
            else if (op.equals("D")) {
                if (nxt[cursor] != -1) cursor = nxt[cursor];
            }
            else if (op.equals("B")) {
                if (pre[cursor] != -1) {
                    remove(cursor);
                    cursor = pre[cursor];
                }
            }
            else if (op.equals("P")) {
                char k = st.nextToken().charAt(0);
                insert(cursor, k);
                cursor = nxt[cursor];
            }
        }

        traverse();
    }

    static void insert(int addr, char c) {
        dat[unused] = c;
        pre[unused] = addr;
        nxt[unused] = nxt[addr];
        if (nxt[addr] != -1) pre[nxt[addr]] = unused;
        nxt[addr] = unused;
        unused++;
    }

    static void remove(int addr) {
        if (nxt[addr] != -1) pre[nxt[addr]] = pre[addr];
        nxt[pre[addr]] = nxt[addr];
    }

    static void traverse() {
        int cur = nxt[0];
        while (cur != -1) {
            sb.append(dat[cur]);
            cur = nxt[cur];
        }
        System.out.print(sb);
    }
}
