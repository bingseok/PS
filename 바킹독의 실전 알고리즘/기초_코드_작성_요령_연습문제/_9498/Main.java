package 기초_코드_작성_요령_연습문제._9498;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int sc = Integer.parseInt(br.readLine());

        if (sc >= 90 && sc <= 100) sb.append("A");
        else if (sc >= 80) sb.append("B");
        else if (sc >= 70) sb.append("C");
        else if (sc >= 60) sb.append("D");
        else sb.append("F");

        System.out.print(sb);
    }
}
