package _01_06;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public String solution1(String str) {
        String answer = "";

        ArrayList<Character> dic = new ArrayList<>();
        for (char c : str.toCharArray()) {
            if (!dic.contains(c)) {
                dic.add(c);
                answer += c;
            }
        }

        return answer;
    }

    public String solution2(String str) {
        String answer = "";

        for (int i = 0; i < str.length(); i++) {
            if (str.indexOf(str.charAt(i)) == i) answer += str.charAt(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.print(T.solution2(str));
    }
}
