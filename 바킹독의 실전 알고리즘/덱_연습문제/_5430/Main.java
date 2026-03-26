package 덱_연습문제._5430;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int t;

    public static void main(String[] args) throws IOException {
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String arr = br.readLine();
            Deque<Integer> DQ = new ArrayDeque<>();

            parse(DQ, arr);

            boolean rev = false;
            boolean err = false;
            for (char op : p.toCharArray()) {
                if (op == 'R') rev = !rev;
                else if (op == 'D') {
                    if (DQ.isEmpty()) {
                        err = true;
                        break;
                    }
                    if (rev) DQ.removeLast();
                    else DQ.remove();
                }
            }

            append_sb(err, rev, DQ);
        }

        System.out.print(sb);
    }

    static void append_sb(boolean err, boolean rev, Deque<Integer> DQ) {
        if (err) {
            sb.append("error\n");
            return;
        }
        sb.append("[");
        Iterator<Integer> it;
        if (rev) it = DQ.descendingIterator();
        else it = DQ.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) sb.append(",");
        }
        sb.append("]\n");
    }

    static void parse(Deque<Integer> DQ, String arr) {
        int res = 0;
        for (int i = 1; i < arr.length() - 1; i++) {
            if (arr.charAt(i) == ',') {
                DQ.add(res);
                res = 0;
            }
            else res = res * 10 + arr.charAt(i) - '0';
        }
        if (res != 0) DQ.add(res);
    }
}
