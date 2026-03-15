package 기초_코드_작성_요령_연습문제._2587;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int arr[] = new int[5];

    public static void main(String[] args) throws IOException {
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }

        Arrays.sort(arr);

        sb.append(sum / 5).append("\n").append(arr[2]);
        System.out.print(sb);
    }
}
