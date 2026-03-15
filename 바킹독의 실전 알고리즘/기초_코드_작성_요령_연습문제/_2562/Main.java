package 기초_코드_작성_요령_연습문제._2562;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int mx = Integer.MIN_VALUE;
        int idx = -1;
        for (int i = 1; i <= 9; i++) {
            int cur = Integer.parseInt(br.readLine());
            if (cur > mx) {
                mx = cur;
                idx = i;
            }
        }

        System.out.println(mx);
        System.out.print(idx);
    }

}
