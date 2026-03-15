package 기초_코드_작성_요령_연습문제._1267;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int n, y, m;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int cur = Integer.parseInt(st.nextToken());
            y += (cur / 30 + 1) * 10;
            m += (cur / 60 + 1) * 15;
        }

        if (y < m) sb.append("Y ").append(y);
        else if (m < y) sb.append("M ").append(m);
        else sb.append("Y M ").append(y);

        System.out.print(sb);
    }
}
