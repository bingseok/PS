package _01._01_12;

import java.util.Scanner;

public class Main {
    public String solution1(int n, String s) {
        String answer = "";
        String[] arr = new String[n];

        // 7개 단위로 substring
        for (int i = 0; i < n; i++) {
            String tmp = s.substring(7*i, 7*(i+1));
            arr[i] = tmp;
        }

        // #는 1로, *는 0으로 replace
        for (int i = 0; i < n; i++) {
            arr[i] = arr[i].replace("#", "1");
            arr[i] = arr[i].replace("*", "0");
        }

        // 이진수로 표현된 문자열을 int 값으로 변환
        for (int i = 0; i < n; i++) {
            int ans = 0;
            for (int j = 0; j < arr[i].length(); j++) {
                ans += (int)Math.pow(2, 6-j) * (int)(arr[i].charAt(j) - '0');
            }
            answer += (char)ans;
        }

        return answer;
    }

    public String solution2(int n, String s) {
        String answer = "";
        for (int i = 0; i < n; i++) {
            String tmp = s.substring(0, 7).replace('#', '1').replace('*', '0');
            int num = Integer.parseInt(tmp, 2);
            s = s.substring(7);
            answer += (char)num;
        }
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        System.out.print(T.solution2(n, s));
    }
}
