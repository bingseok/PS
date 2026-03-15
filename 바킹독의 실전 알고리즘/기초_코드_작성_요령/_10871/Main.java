package 기초_코드_작성_요령._10871;

import java.util.*;
import java.io.*;

public class Main {
    static int n, x;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        // n, x 입력 받기
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int cur = Integer.parseInt(st.nextToken());
            if (cur < x) sb.append(cur).append(" ");
        }
        System.out.print(sb);
    }
}
