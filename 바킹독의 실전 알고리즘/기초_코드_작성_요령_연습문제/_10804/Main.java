package 기초_코드_작성_요령_연습문제._10804;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[] board = new int[21];

    public static void main(String[] args) throws IOException {
        for (int i = 1; i <= 20; i++) {
            board[i] = i;
        }

        for (int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            reverse(a, b);
        }

        for (int i = 1; i <= 20; i++) sb.append(board[i]).append(" ");
        System.out.print(sb);
    }

    static void reverse(int a, int b) {
        int lt = a, rt = b;
        while (lt < rt) {
            int tmp = board[lt];
            board[lt] = board[rt];
            board[rt] = tmp;
            lt++; rt--;
        }
    }


}

