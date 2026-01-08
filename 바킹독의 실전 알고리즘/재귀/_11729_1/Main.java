package 재귀._11729_1;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int n;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        // 옮긴 횟수
        sb.append((1<<n) - 1).append("\n");
        run(n,1, 3);

        System.out.print(sb.toString());
    }

    // 원판 n개를 a번째 장대에서 b번째 장대로 옮기는 수행 과정을 출력하는 함수
    static void run(int n, int a, int b) {
        if (n == 1) {
            sb.append(a).append(" ").append(b).append("\n");
            return;
        }
        run(n-1, a, 6-a-b);
        sb.append(a).append(" ").append(b).append("\n");
        run(n-1, 6-a-b, b);
    }
}
