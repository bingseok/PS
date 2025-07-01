package _01._01_03;

import java.util.*;

public class Main {
    // solution1 : split
    public String solution1(String str) {
        String answer = "";

        String[] arr = str.split(" ");

        int max = Integer.MIN_VALUE;

        for (String t : arr) {
            if (t.length() >= max) {
                answer = t;
                max = t.length();
            }
        }
        return answer;
    }

    // solution : indexOf, substring
    public String solution2(String str) {
        String answer = "";
        int max = Integer.MIN_VALUE, pos;
        while ((pos = str.indexOf(" ")) != -1) {
            String tmp = str.substring(0, pos);
            int len = tmp.length();
            if (len > max) {
                max = len;
                answer = tmp;
            }
            str = str.substring(pos + 1);
        }

        if (str.length() > max) answer = str;
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.print(T.solution2(str));
    }
}