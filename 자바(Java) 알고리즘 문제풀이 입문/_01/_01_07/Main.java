package _01._01_07;

import java.util.*;

public class Main {

    public String solution1(String str) {
        String answer = "";
        str = str.toUpperCase();
        boolean is = true;

        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                is = false;
                break;
            }
            left++; right--;
        }
        if (!is) answer = "NO";
        else answer = "YES";
        return answer;
    }

    public String solution2(String str) {
        String answer = "";
        // str.equalsIgnoreCase()를 통해 toUpperCase() 생략 가능
        str = str.toUpperCase();
        String rev = new StringBuilder(str).reverse().toString();
        if (str.equals(rev)) answer = "YES";
        else return "NO";
        return answer;
    }

    public String solution3(String str) {
        String answer = "YES";
        str = str.toUpperCase();
        int len = str.length();
        for (int i = 0; i < len / 2; i++) {
            if (str.charAt(i) != str.charAt(len - 1 - i)) return "NO";
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
