package 재귀._1629;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static long a, b, c;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        System.out.print(pow(a, b, c));
    }

    static long pow(long a, long b, long c) {
        if (b == 1) return a % c;
        long val = pow(a, b/2, c);
        val = val * val % c;
        if (b % 2 == 0) return val;
        else return val * a % c;
    }




}
