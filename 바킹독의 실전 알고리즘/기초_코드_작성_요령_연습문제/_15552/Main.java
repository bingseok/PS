package 기초_코드_작성_요령_연습문제._15552;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int t, a, b;
    public static void main(String[] args) throws IOException {
        t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            sb.append(a+b).append("\n");
        }
        System.out.print(sb);
    }
}
