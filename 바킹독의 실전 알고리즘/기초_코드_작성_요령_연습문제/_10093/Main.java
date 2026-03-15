package 기초_코드_작성_요령_연습문제._10093;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static long a, b;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        a = Long.parseLong(st.nextToken());
        b = Long.parseLong(st.nextToken());

        if (a > b) {
            long tmp = a;
            a = b;
            b = tmp;
        }

        if (a == b || a+1 == b) sb.append(0).append("\n");
        else sb.append(b-a-1).append("\n");

        for (long i = a + 1; i < b; i++) {
            sb.append(i).append(" ");
        }

        System.out.print(sb);
    }

}
