package 덱_연습문제._5430;

import java.util.*;
import java.io.*;

public class Main_test {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static void parse(String arr, Deque<Integer> dq) {
        int res = 0;
        for (int i = 1; i < arr.length() - 1; i++) {
            if (arr.charAt(i) == ',') {
                dq.addLast(res);
                res = 0;
            }
            else res = res * 10 + (arr.charAt(i) - '0');
        }
        if (res != 0) dq.addLast(res);
    }

    static void append_sb(boolean rev, boolean err, Deque<Integer> dq) {
        if (err) {
            sb.append("error\n");
            return;
        }
        /* Deque -> List를 변환 후 Collections.reverse() 사용
        List<Integer> tmp = new LinkedList<>(dq);
        Collections.reverse(tmp);
        dq = new LinkedList<>(tmp);
         **/


        Iterator<Integer> it;
        sb.append("[");
        if (rev) it = dq.descendingIterator();
        else it = dq.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) sb.append(",");
        }
        sb.append("]\n");
    }

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            Deque<Integer> dq = new LinkedList<>();
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String arr = br.readLine();
            parse(arr, dq);

            boolean rev = false, err = false;
            for (char c : p.toCharArray()) {
                if (c == 'R') rev = !rev;
                else if (c == 'D') {
                    if (dq.isEmpty()) {
                        err = true;
                        break;
                    }
                    if (rev) dq.removeLast();
                    else dq.removeFirst();
                }
            }

            append_sb(rev, err, dq);
        }

        System.out.print(sb);
    }
}
