package _03_05;

import java.util.Scanner;

public class Main {
    public int solution(int n) {
        int answer = 0, sum = 0, lt = 1;
        int m = n/2 + 1;
        int[] arr = new int[m];
        for (int i = 0; i < m; i++) arr[i] = i;

        for (int rt = 1; rt < m; rt++) {
            sum += arr[rt];
            if (sum == n) answer++;
            while (sum >= n) {
                sum -= arr[lt++];
                if (sum == n) answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.print(T.solution(n));
    }
}
