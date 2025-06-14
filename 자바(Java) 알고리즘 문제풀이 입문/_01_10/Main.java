package _01_10;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public int[] solution1(String s, char t) {
        int[] answer = new int[s.length()];
        // for (int i = 0; i < answer.length; i++) answer[i] = -1;
        Arrays.fill(answer, -1);

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == t) {
                for (int j = 0; j < s.length(); j++) {
                    if (answer[j] == -1) // 처음 접근할 때
                        answer[j] = Math.abs(i-j);
                    else if (Math.abs(i-j) < answer[j])
                        answer[j] = Math.abs(i-j);
                }
            }
        }

        return answer;
    }

    public int[] solution2(String s, char c) {
        int[] answer = new int[s.length()];
        int p = 1000;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) p = 0;
            else p++;
            answer[i] = p;
        }

        for (int i= s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == c) p = 0;
            else p++;
            answer[i] = Math.min(answer[i], p);
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char t = sc.next().charAt(0);
        for (int i : T.solution2(s, t)) {
            System.out.print(i + " ");
        }
    }
}
