package _01._01_04;

import java.util.*;

public class Main {

    // StringBuilder의 reverse
    public ArrayList<String> solution1(int n, String[] arr) {
        ArrayList<String> answer = new ArrayList<>();
        for (String str: arr) {
            String tmp = new StringBuilder(str).reverse().toString();
            answer.add(tmp);
        }
        return answer;
    }

    // 직접 뒤집기
    public ArrayList<String> solution2(int n, String[] arr) {
        ArrayList<String> answer = new ArrayList<>();
        for (String str: arr) {
            char[] carr = str.toCharArray();
            int left = 0, right = carr.length- 1;
            while (left < right) {
                char tmp = carr[left];
                carr[left] = carr[right];
                carr[right] = tmp;
                left++; right--;
            }
            String tmp = String.valueOf(carr);
            answer.add(tmp);
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.next();
        }
        for (String str: T.solution2(n, arr)) {
            System.out.println(str);
        }
    }
}
