package 기초_코드_작성_요령_연습문제._2309;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[] arr = new int[9];
    static ArrayList<Integer> ans = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            int cur = Integer.parseInt(br.readLine());
            sum += cur;
            arr[i] = cur;
        }

        Arrays.sort(arr);

        int tar = sum - 100;

        boolean isBreak = false;
        for (int i = 0; i < 9 && !isBreak; i++) {
            for (int j = i + 1; j < 9 && !isBreak; j++) {
                if (arr[i] + arr[j] == tar) {
                        arr[i] = 0; arr[j] = 0;
                        isBreak = true;
                }
            }
        }

        for (int i = 0; i < 9; i++) {
            if (arr[i] != 0) sb.append(arr[i]).append("\n");
        }

        System.out.print(sb);
    }

}
