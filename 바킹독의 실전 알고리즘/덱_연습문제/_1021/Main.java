package 덱_연습문제._1021;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static Deque<Integer> DQ = new ArrayDeque<>();
    static int n, m, ans;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) DQ.add(i);

        st = new StringTokenizer(br.readLine());
        while (m-- > 0) {
            int t = Integer.parseInt(st.nextToken());
            Iterator<Integer> it = DQ.iterator();

            int lt = 0, rt = 0;
            while (it.next() != t) lt++;
            rt = DQ.size() - lt;

            if (lt <= rt) {
                while (DQ.peek() != t) {
                    DQ.add(DQ.peek());
                    DQ.remove();
                    ans++;
                }
                DQ.remove();
            }
            else {
                while (DQ.peek() != t) {
                    DQ.addFirst(DQ.peekLast());
                    DQ.removeLast();
                    ans++;
                }
                DQ.remove();
            }
        }

        System.out.print(ans);
    }

}
