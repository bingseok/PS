package _01._01_09;

import java.util.Scanner;

public class Main {

    public int solution1(String str) {
        int answer = 0;
        str = str.toUpperCase().replaceAll("[A-Z]", "");
        str = new StringBuilder(str).reverse().toString();

        for (int i = 0; i < str.length(); i++) {
            int mul = (int)Math.pow(10, i);
            answer += Character.getNumericValue(str.charAt(i)) * mul;
        }

        return answer;
    }

    public int solution2(String str) {
        int answer = 0;
        for (char c : str.toCharArray()) {
            if (c >= '0' && c <= '9') answer = answer * 10 + (c - '0');
        }
        return answer;
    }

    public int solution3(String str) {
        String answer = "";
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) answer += c;
        }
        return Integer.parseInt(answer);
    }
    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.print(T.solution2(str));
    }
}
