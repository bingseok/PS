package 배열_연습문제._10808;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[] arr = new int[26];

    public static void main(String[] args) throws IOException {
        String s = br.readLine();
        for (char c : s.toCharArray()) {
            arr[c-'a']++;
        }

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
