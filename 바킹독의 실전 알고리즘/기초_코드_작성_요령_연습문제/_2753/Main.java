package 기초_코드_작성_요령_연습문제._2753;

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int yr = Integer.parseInt(br.readLine());

        if ((yr % 4 == 0 && yr % 100 != 0) || yr % 400 == 0)  sb.append("1");
        else sb.append("0");

        System.out.print(sb);
    }
}
