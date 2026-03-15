package 기초_코드_작성_요령_연습문제._2752;

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[] arr = new int[3];

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]).append(" ");
        }

        System.out.print(sb);
    }
}
