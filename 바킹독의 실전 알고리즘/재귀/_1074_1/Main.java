package 재귀._1074_1;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int n, r, c;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        System.out.print(run(n, r, c));
    }

    // 2^n x 2^n 배열에서 r행 c열을 몇 번째로 방문하는지 반환하는 함수
    static int run(int n, int r, int c) {
        if (n == 0) return 0;
        int half = 1 << n-1;

        // 1 사분면
        if (r < half && c < half) return run(n-1, r, c);
        // 2 사분면
        if (r < half && c >= half) return half * half + run(n-1, r, c - half);
        // 3 사분면
        if (r >= half && c < half) return 2 * half * half + run(n-1, r - half, c);
        // 4 사분면
        return 3 * half * half + run(n-1, r-half, c-half);
    }
}
