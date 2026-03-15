package 기초_코드_작성_요령_연습문제._2480;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int[] arr =  new int[3];

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        if (arr[0] == arr[2]) sb.append(10000 + arr[0] * 1000);
        else if (arr[1] == arr[0] || arr[1] == arr[2]) sb.append(1000 + arr[1] * 100);
        else sb.append(arr[2] * 100);

        System.out.print(sb);
    }

}
