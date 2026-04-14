package 재귀.P1;

import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int k = Integer.parseInt(br.readLine());

        test1(k);
        System.out.println(test2(k));
    }

    // 1부터 n까지 출력하는 함수
    static void test1(int k) {
        if (k == 0) return;
        System.out.print(k);
        test1(k-1);
    }

    // 1부터 n까지의 합을 출력하는 함수
    static int test2(int k) {
        if (k == 1) return k;
        return k + test2(k-1);
    }

}
