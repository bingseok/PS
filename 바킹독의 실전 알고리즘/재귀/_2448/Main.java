package 재귀._2448;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int n;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++)
                sb.append(func(i, j, n));
            sb.append("\n");
        }
    }

    static String func(int i, int j, int n) {
        if (i < n && j < n) return " ";
        if (i > n && j < n) {
            if (j == 2 * n - 1) return  " \n";
            else return " ";
        }

        if (i )


    }
}
