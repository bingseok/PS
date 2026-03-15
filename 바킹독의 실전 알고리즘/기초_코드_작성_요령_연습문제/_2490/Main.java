package 기초_코드_작성_요령_연습문제._2490;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static String arr = "EABCD";

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            int sum = 0;
            for (int j = 0; j < 4; j++) {
                int x = Integer.parseInt(st.nextToken());
                if (x == 0) sum++;
            }
            sb.append(arr.charAt(sum)).append("\n");
        }

        System.out.print(sb);
    }

}
