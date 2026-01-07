package 재귀.P1;

import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int k;
    public static void main(String[] args) throws IOException {
        k = Integer.parseInt(br.readLine());

        run1(1);
        System.out.print(run2(k));
    }

    // 1~k 까지 출력하는 재귀 함수
    static void run1(int i) {
        System.out.print(i + " ");
        if (i == k) return;
        run1(i+1);
    }

    // 1~n까지 합을 출력하는 재귀 함수
    static int run2(int k) {
        if (k == 0) return 0;
        return k + run2(k-1);
    }
}
