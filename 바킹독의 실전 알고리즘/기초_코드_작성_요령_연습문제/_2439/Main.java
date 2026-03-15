package 기초_코드_작성_요령_연습문제._2439;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++)
                sb.append(" ");
            for (int j = 0; j <= i; j++)
                sb.append("*");
            sb.append("\n");
        }

        System.out.print(sb);

    }
}
