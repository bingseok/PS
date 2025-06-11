package _01_05;

import java.util.*;

public class Main {

    public String solution1(String str) {
        String answer = "";
        char[] arr = str.toCharArray();
        int left = 0, right = str.length() - 1;

        while (true) {
            while (!Character.isAlphabetic(arr[left])) left++;
            while (!Character.isAlphabetic(arr[right])) right--;

            if (left >= right) break;

            char tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            left++; right--;
        }

        answer = String.valueOf(arr);
        return answer;
    }

    public String solution2(String str) {
        String answer = "";
        char[] arr = str.toCharArray();
        int lt = 0, rt = str.length() - 1;
        while (lt < rt) {
            if (!Character.isAlphabetic(arr[lt])) lt++;
            else if (!Character.isAlphabetic(arr[rt])) rt--;
            else {
                char tmp = arr[lt];
                arr[lt] = arr[rt];
                arr[rt] = tmp;
                lt++; rt--;
            }
        }
        answer = String.valueOf(arr);
        return answer;
    }
    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.print(T.solution2(str));
    }
}
