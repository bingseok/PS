package 배열_연습문제._2577;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int[] arr = new int[10];
    static int a, b, c;
    public static void main(String[] args) throws IOException {
        a = Integer.parseInt(br.readLine());
        b = Integer.parseInt(br.readLine());
        c = Integer.parseInt(br.readLine());

        int res = a * b * c;
        while (res != 0) {
            arr[res % 10]++;
            res /= 10;
        }

        for (int x : arr) System.out.println(x);
    }
}
