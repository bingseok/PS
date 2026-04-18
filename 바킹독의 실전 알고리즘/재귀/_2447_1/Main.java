package 재귀._2447_1;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int n;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(func(i, j, n));
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    static char func(int r, int c, int n) {
        // 크키 n 기준에서 (r, c)가 3x3 중 어디에 위치해있는지
        if ((r / n) % 3 == 1 && (c / n) % 3 == 1)  {
            return ' ';
        }
        else {
            if (n / 3 == 0) return '*';
            else return func(r, c, n/3);
        }

    }
}
