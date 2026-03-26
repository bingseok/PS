package 큐_연습문제._2164;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static Deque<Integer> Q = new ArrayDeque<>();
    static int n;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        for (int i = 1; i <= n; i++) Q.add(i);

        while (Q.size() != 1) {
            Q.remove();
            Q.add(Q.peek());
            Q.pop();
        }

        System.out.print(Q.peek());
    }

}
