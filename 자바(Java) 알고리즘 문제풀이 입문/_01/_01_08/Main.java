package _01._01_08;

import java.util.Scanner;

public class Main {
    public String solution1(String str) {
        String answer = "YES";
        str = str.toLowerCase();
        char[] arr = str.toCharArray();
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (!Character.isAlphabetic(arr[left])) left++;
            else if (!Character.isAlphabetic(arr[right])) right--;
            else {
                if (arr[left] != arr[right]) return "NO";
                left++; right--;
            }
        }
        return answer;
    }

    public String solution2(String str) {
        String answer = "NO";
        str = str.toUpperCase().replaceAll("[^A-Z]", "");
        String rev = new StringBuilder(str).reverse().toString();
        if (str.equals(rev)) answer = "YES";
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.print(T.solution2(str));
    }
}
