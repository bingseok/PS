package 스택_연습문제._2493;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static Deque<Pair> DQ = new ArrayDeque<>();
    static int n, index;

    public static void main(String[] args) throws IOException {
        DQ.push(new Pair(index, Integer.MAX_VALUE));
        index++;

        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        while (n-- > 0) {
            int cur = Integer.parseInt(st.nextToken());
            while (DQ.peek().height < cur) {
                DQ.pop();
            }
            sb.append(DQ.peek().index).append(" ");
            DQ.push(new Pair(index, cur));
            index++;
        }

        System.out.print(sb);
    }

    static class Pair {
        int index;
        int height;
        Pair(int index, int height) {
            this.index = index;
            this.height = height;
        }
    }
}
