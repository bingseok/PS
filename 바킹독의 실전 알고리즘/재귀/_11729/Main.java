package 재귀._11729;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int n;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        sb.append((1L << n) - 1).append('\n');
        run(1, 3, n);
        System.out.print(sb.toString());
    }

    // 기둥 a에서 기둥 b로 n개의 원판을 움직이는 함수
    // 1. 원판 1개를 옮길 수 있다.
    // 2. 원판 k-1개를 옮길 수 있으면, 원판 k개를 옮길 수 있다.
    static void run(int a, int b, int n) {
        if (n == 1) {
            sb.append(a).append(" ").append(b).append('\n');
            return;
        }
        run(a, 6-a-b, n-1);
        sb.append(a).append(" ").append(b).append('\n');
        run(6-a-b, b, n-1);
    }

    /**
     * 1. 옮긴 횟수 : 2^k - 1, k가 20 미만 이지만 옮긴 횟수 출력 시 안전하게 long 형으로
     * 2. 옮길 때마다 출력을 진행하는데, 출력의 최대 횟수가 2^20 - 1번임.
     *    System.out.print 대신 StringBuilder 사용
     */
}
