package 배열_연습문제._1475;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int[] arr = new int[10];
    static int n;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        while (n != 0) {
            arr[n%10]++;
            n /= 10;
        }
        arr[9] = (arr[6] + arr[9] + 1) / 2;
        arr[6] = 0;

        int mx = 0;
        for (int x : arr) {
            mx = Math.max(mx, x);
        }
        System.out.print(mx);
    }

}
