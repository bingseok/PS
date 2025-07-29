package 덱_연습문제._5430;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String p = br.readLine();
            Deque<Integer> dq = new LinkedList<>();
            int n = Integer.parseInt(br.readLine());
            String arr = br.readLine();
            int res = 0;
            for (int i = 1; i < arr.length() - 1; i++) {
                if (arr.charAt(i) == ',') {
                    dq.addLast(res);
                    res = 0;
                }
                else res = res * 10 + (arr.charAt(i) - '0');
            }
            if (n != 0) dq.addLast(res);

            boolean rev = false, err = false;
            for (char c : p.toCharArray()) {
                if (c == 'R') rev = !rev;
                else if (c == 'D') {
                    if (dq.isEmpty()) {
                        err = true;
                        break;
                    }
                    else if (rev) dq.removeLast();
                    else dq.removeFirst();
                }
            }

            if (err) sb.append("error\n");
            else {
                sb.append("[");
                if (rev) {
                    while (!dq.isEmpty()) {
                        sb.append(dq.peekLast());
                        if (dq.size() != 1) sb.append(",");
                        dq.removeLast();
                    }
                }
                else {
                    while (!dq.isEmpty()) {
                        sb.append(dq.peekFirst());
                        if (dq.size() != 1) sb.append(",");
                        dq.removeFirst();
                    }
                }
                sb.append("]\n");
            }
        }
        System.out.print(sb);
    }
}
