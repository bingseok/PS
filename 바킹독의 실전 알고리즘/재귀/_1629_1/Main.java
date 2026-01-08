package 재귀._1629_1;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static long a, b, c;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        a = Long.parseLong(st.nextToken());
        b = Long.parseLong(st.nextToken());
        c = Long.parseLong(st.nextToken());

        System.out.print(run(a, b, c));
    }

    // a^b를 c로 나눈 나머지를 출력하는 함수
    static long run(long a, long b, long c) {
        if (b == 1) return a % c;
        long val = run(a, b/2, c);
        val = val * val % c;
        if (b % 2 == 0) return val;
        return val * a % c;
    }
}
