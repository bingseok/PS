package 배열_연습문제._3273;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int[] freq = new int[2000005];
    static int[] arr = new int[1000005];

    static int n, res, x;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            freq[arr[i]] = 1;
        }

        x = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            if (arr[i] < x && freq[x - arr[i]] == 1) res++;
        }

        System.out.print(res / 2);
    }


}
