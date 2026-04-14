package 재귀._11729;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int n;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        sb.append((1 << n) - 1).append("\n");
        move(1, 3, n);
        System.out.print(sb);
    }

    static void move(int a, int b, int n) {
        if (n == 1) {
            sb.append(a).append(" ").append(b).append("\n");
            return;
        }
        move(a, 6-a-b, n-1);
        sb.append(a).append(" ").append(b).append("\n");
        move(6-a-b, b, n-1);
    }

}
