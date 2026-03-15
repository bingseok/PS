package 기초_코드_작성_요령_연습문제._2576;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static ArrayList<Integer> arr = new ArrayList<>();
    static int sum;

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 7; i++) {
            int cur = Integer.parseInt(br.readLine());
            if (cur % 2 == 1) {
                sum += cur;
                arr.add(cur);
            }
        }

        Collections.sort(arr);

        if (arr.size() == 0) sb.append("-1");
        else {
            sb.append(sum).append("\n");
            sb.append(arr.get(0));
        }
        
        System.out.print(sb);
    }

}
