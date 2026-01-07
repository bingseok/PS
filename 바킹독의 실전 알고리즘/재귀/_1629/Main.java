package 재귀._1629;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static long a, b, c;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        System.out.print(run(a, b, c));
    }

    static long run(long a, long b, long c) {
        // 1. 1승의 나머지를 구할 수 있다.
        // 2. k승의 나머지를 구할 수 있으면, 2k, 2k+1 승의 나머지를 구할 수 있다.
        if (b == 1) return a % c;
        long val = run(a, b/2, c);
        val = val * val % c;
        // 지수 승이 짝수이면,
        if (b % 2 == 0) return val;
        return val * a % c;
    }

    /**
     * 1. 큰 값을 다루므로, 혹시 모를 경우를 대비해 long형으로 다루기
     * 2. long val = run(a, b/2, c); 로 재귀함수 호출 부분을 변수에 담음.
     *    val을 사용해서 run()을 한 번만 호출
     */
}
